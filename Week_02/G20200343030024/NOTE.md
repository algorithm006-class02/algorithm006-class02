# Week 02 学习总结

## HashMap实现学习
1. HashMap的数据结构: Hash值采用的数组，实际存储对象采用链表。在Hash算法不合理的情况下，时间复杂度将会退化成O(n). 所以可以考虑将链表改成树形结构，降低查询的复杂度。
```java
  transient Node<K,V>[] table; // Hash值采用数组，
  static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next; // 链表，
  }
```

HashMap中的链表改成Tree结构代码示意，可以使用这周的学的查找树去实现
```java
transient Node<K,V>[] table; // Hash值采用数组，
static class Node<K,V> implements Map.Entry<K,V> {
    final int hash;
    final K key;
    V value;
    Node<K,V> parent;
    Node<K,V> left; 
    Node<K,V> right; 
}

// 假设hash方法已实现
int hash(K key);

public V put(K key, V value){
    // 这里主要展示查找树的操作，就不考虑扩容的事情了
    if (table[(table.length - 1) & hash(key)] == null) {
        table[(table.length - 1) & hash(key)] = newNode(hash,key, value);
    } else {
        Node root = table[(table.length - 1) & hash(key)];
        // 找到对应插入的节点
        Node current = root;
        Node previous =null;  
        while(current != null){
            if (current.key.equals(key)){
                current.value = value;
                return value;
            }
            
             previous = current;
            if (current.left.K.hashCode() > key.hashCode()){
                current = current.left;
            } else {
                current = current.right;
            }
        }
        Node n = newNode(hash, key, value);
        n.parent = previous;
        if (previous.key.hashCode() > key.hashCode()){
            previous.left = n;
        } else {
            previous.right = n;
        }
    }
}


public V remove(K key){
   Node root = table[(table.length - 1) & hash(key)];
   if (root == null){
       return null;
   }

   Node current = root;
   while(current != null){
       if (current.key.equals(key)){
           break;
       }

       if (current.left.K.hashCode() > key.hashCode()){
           current = current.left;
       } else {
           current = current.right;
       }
   }

    if (current == null){
        return null;
    }

   // 找到要删除的节点啦，要准备删除了, 指针要整蒙圈了，
   // 但总纲得确保：
   // 1. 左枝永远小于本身，右枝永远大于本身
   // 2. 左枝的所有孩子中最大的节点：左枝最底层的右节点
   // 3. 右枝的所有孩子中最小的节点：右枝最底层的左节点
   if (current.left == null){
        Transplant(table[(table.length - 1) & hash(key)], current, current.right)
   } else if (current.right == null){
        Transplant(table[(table.length - 1) & hash(key)], current, current.left)
   } else {
        Node min = current.right;
        while(max.left != null){
            min = min.left;
        }
       
         // min选出来的继承节点
        if (min.parent != current){ // 此时选出的节点肯定没有left
            // 跨级提拔，首先min让比自己大的节点都挂到自己的父亲的左节点上，让min顺利上位，
            Transplant(table[(table.length - 1) & hash(key)], min, min.right)
            // 先让跨级的min根current本身的right打好关系
            min.right = current.right;
             // 安抚好比自己大的节点的心情
            min.right.parent = min
        }

        // 让min根current的上级都打好关系
        Transplant(table[(table.length - 1) & hash(key)], current, min)
        // 跟current的left打好关系
        min.left = current.left;
        min.left.parent = min
   }
    
    void Transplant(Node r, Node x, Node y)  {  
        if (x.parent == NULL)  
            r = y;  
        else if (x == x.parent.left)  
            x.parent.left = y;  
        else  
            x.parent.right = y;  
  
        if (y != null)  
            y.parent = x.parent;  
    } 

}

```


## 叉树题目的解法
### 递归
递归过于简单，就不写了
### Stack
Stack简单，就不写了
### 莫里斯解法
* 核心思想：遍历完左子树之后，能够回到右子树。 做一个链接将左子树的最后一个右孩子链接到右孩子上。
* 执行单元: 找到左子树的最后一个右孩子，链接上当前遍历的右子树上
* 重复单元：遍历树的每一个节点
* 时间复杂度：O(n)
* 空间复杂度：O(1)

### 使用队列完成层序遍历


## 组合
### 回溯解法
过程： 遍历，添加，递归，回退
```java
class Solution {

  private int k;
  private int n;
  private List<List<Integer>> output;
  
  public List<List<Integer>> combine(int n, int k) {
      this.k = k;
      this.output = new ArrayList<List<Integer>>();
      helper(1, n + 1, new LinkedList<Integer>());

      return output;
  }

  public void helper(int start, int end, LinkedList<Integer> curr){
      if (curr.size() ==  k){
          output.add(new ArrayList<Integer>(curr));
          return;
      }

      for (int i = start; i < end; i++){
          curr.add(i);
          helper(i + 1, end, curr);
          curr.removeLast();
      }

  }

}
```
