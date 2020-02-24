# 学习笔记

## hash小结

### 原理

hashtable底层不保证物理内存顺序，实现插入，查找和删除时间复杂度O(1)，这三种操作都是基于模仿了数组的随机访问：

1. 数组随机访问，通过数组下标index访问value，index-->内存地址-->value
2. hashtable查找，通过关键字key访问value，key-->hashfun(key)-->index-->内存地址-->value

所以hash操作时间复杂度的关键是hashfun(key)时间复杂度，另外这个hashfun也部分决定了冲突发生的概率。

### java源码LinkedHashSet LinkedHashMap分析

java的LinkedHashSet继承HashSet，而HashSet存储数据用了HashMap，key-value的value使用了
``` java
private static final Object PRESENT = new Object()
```

java的LinkedHashMap继承HashMap。
所以LinkedHashSet LinkedHashMap的hash函数都在HashMap里面。

### java源码HashMap分析

存储值
```java
Node<K,V>[] table //真正存储的地方
```

value类型node，除了存储开发者关注的value外，还保存了hash值，以及hash冲突时节点next(源码的很多处使用TreeNode，未分析)
```java
static class Node<K,V> implements Map.Entry<K,V> {
    final int hash;
    final K key;
    V value;
    Node<K,V> next;

    Node(int hash, K key, V value, Node<K,V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }
    ...
}
```

查找，只给开发者返回value，屏蔽底层node的其他信息，根据hashfun计算index：(n - 1) & hash
```java
public V get(Object key) {
    Node<K,V> e;
    return (e = getNode(hash(key), key)) == null ? null : e.value;
}

final Node<K,V> getNode(int hash, Object key) {
        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & hash]) != null) {
            if (first.hash == hash && // always check first node
                ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.next) != null) {
                if (first instanceof TreeNode)
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                do {
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
}
```

插入，更新
```java
public V put(K key, V value) {
    return putVal(hash(key), key, value, false, true);
}

final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
}
```

源码为了计算效率，大量使用了位运算符，赋值表达式返回值

### hash算法

hash算法调用了object.hashCode，一个原生native方法，具体c源码不讨论。

## 解题

### leetcode 49

想到用hashtable(python3中dict)，按照排序后str作为key，讲srcStr追加到value数组
官方用了collections模块对比：
1. dict要求key是不可变对象，官方tuple(sorted(s)作为key，自己"".join(sorted(value))
2. 避免了dict操作中key不存在时的异常，代码简洁
3. 执行时间无法确认，leetcode同一代码每次执行不一样，空间使用一样

### leetcode 94 144

树的遍历，以root的遍历顺序命名，采用递归

### leetcode 429

树的广度遍历，关键记录当前level的所有元素，一次调用递归

### leetcode 105

考察树的遍历结果特征
1. 前序 root-->left all-->right all
1. 中序 left all-->root-->right all