学习笔记

### HashMap源码分析

HashMap本质上是使链表法来解决哈希冲突的一种哈希表，每个桶（Bucket）都对应一条链表，所有散列值相同的元素都会放到相同槽位对应的链表中。
如果某一个桶（Bucket）里的链表太长，超过了TREEIFY_THRESHOLD = 8之后，会转化为一颗红黑树来存储散列值相同的元素。   
我们主要分析put和get两个方法的源代码。

#### 关键成员变量

* transient Node<K,V>[] table; 实际的存储数据的hash表。第一次用的时候初始化，在有必要的时候会resized。每次分配的时候，数组的长度是2的整数幂。


#### public V put(K key, V value)
put是调用的final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                          boolean evict)方法。   
其中hash参数是，调用的static final int hash(Object key)方法运算得来。

##### final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict)

* 首先判断存储表是否初始化，如果没有先初始化存储表，也就是Node<K,V>[] table。
* 计算Key应该存储在哪个Bucket，i = (n - 1) & hash。 n为table的长度，hash为putVal的第一个参数hash。
* 如果计算出来的Bucket里没有值（说明未发生哈希碰撞），则newNode(hash, key, value, null)，插入到此Bucket中。
* 如果此Bucket有值（说明发生了哈希碰撞）。
* 哈希碰撞之后首先判断此Bucket里是使用红黑树存储碰撞之后的数据还是链表，然后将数据插入到对应的数或者链表中。
* 如果是链表，并且链表的长度已经达到了TREEIFY_THRESHOLD = 8，则调用treeifyBin(Node<K,V>[] tab, int hash)将存储改为红黑树。
* 然后实现在onlyIfAbsent=false的时候的对应的操作，此处不做详细分析。
* 如果哈希表中的数据大于了threshold，就会调用Node<K,V>[] resize()。
* resize函数会重置threshold以及哈希表Node<K,V>[] table。具体先不做分析，后续再补齐这部分的分析。



##### static final int hash(Object key) 
````
 static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
````
此处将key的hashCode做了一次扰动，减小了哈希碰撞的概率。


#### public V get(Object key)
调用的Node<K,V> getNode(int hash, Object key)方法。其中hash是调用的static final int hash(Object key)方法算出的。

#####  Node<K,V> getNode(int hash, Object key)

* 根据hash找到对应的存储Bucket。
* 如果Bucket里边第一个Node即为key，则返回数据。
* 如果Bucket中存的是链表，则遍历链表找到对应的key。
* 如果Bucket中存的是红黑树，则搜索找到对一个的key。
