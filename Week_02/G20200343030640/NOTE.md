学习笔记

关于HashMap总结:
从定义可知：
```java
public class HashMap<K,V>
extends AbstractMap<K,V>
implements Map<K,V>, Cloneable, Serializable
```
基于hashtable实现了Map接口。
java 10中，HashMap 默认容量DEFAULT_CAPACITY=16；

### HashMap构造函数
```java
public HashMap(int initialCapacity, float loadFactor)
 {
    if (initialCapacity < 0)
       throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
    if (! (loadFactor > 0)) // check for NaN too
    throw new IllegalArgumentException("Illegal Load: " + loadFactor);
  
      if (initialCapacity == 0)
        initialCapacity = 1;
      buckets = (HashEntry<K, V>[]) new HashEntry[initialCapacity];
      this.loadFactor = loadFactor;
      threshold = (int) (initialCapacity * loadFactor);
    }
```
buckets是一个容量为initialCapacity的一维hashtable, 每个元素指向一个单链表，链表中的元素为HashEntry<K,V>类型的节点，通过next指向下一个元素。

### HashMap的get方法
```java
public V get(Object key)
{
    int idx = hash(key);
    HashEntry<K, V> e = buckets[idx];
    while (e != null){
        if (equals(key, e.key))
            return e.value
        e = e.next
    }
    return null;
}
```
对Key计算hash值，作为hashtable下标获取元素，然后下标对应的元素的单链表访问，查找key的值。

### HashMap的remove方法
```java
public V remove(Object key)
{
    int idx = hash(key);
    HashEntry<K, V> e = buckets[idx];
    HashEntry<K, V> last = null;
    while (e != null){
        if (equals(key, e.key)){
            modCount++;
            if (last == null)
                buckets[idx] = e.next;
            else
                last.next = e.next;
            size--;
            // Method call necessary for LinkedHashMap to work correctly.
            return e.cleanup();
        }
        last = e;
        e = e.next;
    }
    return null;
}
```
对KEY进行hash，然后在单链表上进行删除操作


### HashMap的addEntry方法
```java
void addEntry(K key, V value, int idx, boolean callRemove)
{
    HashEntry<K, V> e = new HashEntry<K, V>(key, value);
    e.next = buckets[idx];
    buckets[idx] = e;
}
```
创建一个HashEntry类型的元素，然在单链表头部执行插入操作。

### HashMap的put方法
```java
public V put(K key, V value)
{
    int idx = hash(key);
    HashEntry<K, V> e = buckets[idx];

    while (e != null){
        if (equals(key, e.key)){
            e.access(); // Must call this for bookkeeping in LinkedHashMap.
            V r = e.value;
            e.value = value;
            return r;
        } else
            e = e.next;
    }

    // At this point, we know we need to add a new entry.
    modCount++;
    if (++size > threshold){
        rehash();
        // Need a new hash value to suit the bigger table.
        idx = hash(key);
    }

    // LinkedHashMap cannot override put(), hence this call.
    addEntry(key, value, idx, true);
    return null;
}
```
put操作首先计算hash，然后访问单链表，若找到则返回value; 若没有找到，则调用addEntry方法添加元素。

HashMap是用一个一维数组和单链表实现的数据结构，一维数组中每个元素相当于每个单链表的头指针。

HashMap源码：
http://developer.classpath.org/doc/java/util/HashMap-source.html#line.456