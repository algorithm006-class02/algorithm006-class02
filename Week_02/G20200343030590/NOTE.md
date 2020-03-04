学习笔记

# HashMap的小总结

- 首先解读下HashMap的源码（参考JDK8），讲述下它能提供什么功能（能做什么）以及为什么这么做，还能怎么做。源码很长，单类一共2400行，
这里我们只分析一下算法题目以及日常业务开发中最看重和常用的方法。先从整体介绍下特性。
  - 类头的概要需要着重看一下，这里提到HashMap的一个特性也是面试中经常考到的，它允许null值和null键。
  - 再看下时间复杂度。HashMap提供了线性时间的get、put操作（因为HashMap可以视为array和linkedList的结合）。可以将其视为将元素
  都分到了多个桶内。由于在多个桶之间遍历，时间复杂度正比于kv的数量和桶之和，所以不要将容量设置过大或负载因子过小，一般我们都会先分
  配一个初始值限定这两个参数的大小。
  从实现上看，如果桶十分大（冲突键值过多）的化，会导致HashMap退化为TreeMap。由于TreeMap在冲突键特别多时提供了良好的检索性能（O(log(n))）。
  而且保证了有序性。使用TREEIFY_THRESHOLD来定义容量达到多少时转变为TreeMap。
  - 过高的负载因子虽然减少了空间负载，但是却增加了检索的成本。所以在设计时需要很好地权衡这一点，以期尽量减少rehash的次数。
  - 多线程。学过java的基本都会知道HashMap不是线程安全的，只能通过外部同步来实现线程安全性。这里提到了结构化变更的定义：
  只是修改值不算结构化变更，只有增加或删除key的操作才算。设计者因为考虑到多线程会破坏HashMap的结构所以不让它支持多线程。后面再讲
  ConcurrentHashMap是怎么支持的。
  - 不可变性。在遍历过程中如果产生了结构化变更（比如删除键），那么会进行fail-fast操作：抛出ConcurrentModificationException。
  这里需要注意的是这种fail-fast行为仅仅用来检测bug的存在，即运行时遍历过程中的漏洞，切记不能用作正确性的判断，及catch住这个异常
  进行相应的处理是不对的。
 
- 下面介绍具体的功能。
  - 因为HashMap内部是用数组实现的，而每个数组中存放的元素也就是键值对，这个键值对假设用Node表示，则Node的数据结构如下：
  ```
    static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;
        ...
    }
    
    public final int hashCode() {
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }
  ```
  - 根据设置的容量计算HashMap的size：
  ```
  static final int tableSizeFor(int cap) {
      int n = cap - 1;
      n |= n >>> 1;
      n |= n >>> 2;
      n |= n >>> 4;
      n |= n >>> 8;
      n |= n >>> 16;
      return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
  }
  ```
  - 表明了底层使用了数组实现：
  ```
  transient Node<K,V>[] table;
  ```
  - 在AbstractMap基础上扩展出来的entrySet：
  ```
  transient Set<Map.Entry<K,V>> entrySet;
  ```
  - 记录发生结构化变更的次数，在判断是否需要抛出抛出ConcurrentModificationException时会参考这个值：
  ```
  transient int modCount;
  ```
  - HashMap的初始化，主要通过几种常见方式，这里只看参数，忽略实现：
  ```
  HashMap(int initialCapacity, float loadFactor) {
    ...
  }
  HashMap(int initialCapacity) {
    ...
  }
  HashMap() {
    ...
  }
  HashMap(Map<? extends K, ? extends V> m) {
    ...
  }
  
  ```
  - 支持延迟初始化，延迟插入操作由子类提供（此处为LinkedListMap）：
  ```
  putMapEntries(Map<? extends K, ? extends V> m, boolean evict)
  ```
  - map提供的基础功能实现不做介绍
  - 下面看下resize，使用二分查找实现了插入节点的操作。
  ```
  final Node<K,V>[] resize() {
     ...
     if (e.next == null)
         newTab[e.hash & (newCap - 1)] = e;
     else if (e instanceof TreeNode)
         ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
     else { // preserve order
         Node<K,V> loHead = null, loTail = null;
         Node<K,V> hiHead = null, hiTail = null;
         Node<K,V> next;
         do {
             next = e.next;
             if ((e.hash & oldCap) == 0) {
                 if (loTail == null)
                     loHead = e;
                 else
                     loTail.next = e;
                 loTail = e;
             }
             else {
                 if (hiTail == null)
                     hiHead = e;
                 else
                     hiTail.next = e;
                 hiTail = e;
             }
         } while ((e = next) != null);
         if (loTail != null) {
             loTail.next = null;
             newTab[j] = loHead;
         }
         if (hiTail != null) {
             hiTail.next = null;
             newTab[j + oldCap] = hiHead;
         }
     }
     ...
  }
  ```
  - resize只有在hash桶数量较少时使用，如果数量超过了初始化的THRESHOLD，则使用treeifybin方法，从下面代码可以看出：
  ```
  final void treeifyBin(Node<K,V>[] tab, int hash) {
      int n, index; Node<K,V> e;
      if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
          // 数量小于MIN_TREEIFY_CAPACITY时使用resize
          resize();
      else if ((e = tab[index = (n - 1) & hash]) != null) {
          TreeNode<K,V> hd = null, tl = null;
          do {
              TreeNode<K,V> p = replacementTreeNode(e, null);
              if (tl == null)
                  hd = p;
              else {
                  p.prev = tl;
                  tl.next = p;
              }
              tl = p;
          } while ((e = e.next) != null);
          if ((tab[index] = hd) != null)
              hd.treeify(tab);
      }
    }
  ```
  treeifybin还广泛应用于putVal、compute、computeIfAbsence和merge方法中。
  - 最后看下内部节点TreeNode，它是经过treeifybin后的内部节点，可以看到HashMap内部是继承自LinkedHashMap.Entry的。可以实现线性时间复杂度的
  插入，查找操作。这个功能在JDK8中的实现区别于JDK1.7，主要区别于JDK8中使用红黑树代替了二叉查找树的实现。
  ```
  static final class TreeNode<K,V> extends LinkedHashMap.Entry<K,V> {
      TreeNode<K,V> parent;  // red-black tree links
      TreeNode<K,V> left;
      TreeNode<K,V> right;
      TreeNode<K,V> prev;    // needed to unlink next upon deletion
      boolean red;
      
      ...
  ```
  建立树的操作：
  ```
  final void treeify(Node<K,V>[] tab) {
      TreeNode<K,V> root = null;
      for (TreeNode<K,V> x = this, next; x != null; x = next) {
          next = (TreeNode<K,V>)x.next;
          x.left = x.right = null;
          if (root == null) {
              x.parent = null;
              x.red = false;
              root = x;
          }
          else {
              K k = x.key;
              int h = x.hash;
              Class<?> kc = null;
              for (TreeNode<K,V> p = root;;) {
                  int dir, ph;
                  K pk = p.key;
                  if ((ph = p.hash) > h)
                      dir = -1;
                  else if (ph < h)
                      dir = 1;
                  else if ((kc == null &&
                            (kc = comparableClassFor(k)) == null) ||
                           (dir = compareComparables(kc, k, pk)) == 0)
                      dir = tieBreakOrder(k, pk);

                  TreeNode<K,V> xp = p;
                  if ((p = (dir <= 0) ? p.left : p.right) == null) {
                      x.parent = xp;
                      if (dir <= 0)
                          xp.left = x;
                      else
                          xp.right = x;
                      root = balanceInsertion(root, x);
                      break;
                  }
              }
          }
      }
      moveRootToFront(tab, root);
  }
  ```
  剩余的代码主要是红黑树的插入，删除等操作实现，不细讲。