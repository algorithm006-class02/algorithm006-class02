# HashMap 源码分析

1.初始化的时候并不是用传入的值，如果这个值大于1，则返回大于这个值的最近的2的幂次方数

## jdk1.7

### put方法

```java
public V put(K key, V value) {
    // table 为空进行初始化
    if (table == EMPTY_TABLE) {
        // threshold数组容量
        inflateTable(threshold);
    }
    if (key == null)
        // key 等于 null 直接放在第0个位置
        return putForNullKey(value);
    int hash = hash(key);
    // 计算数组的下标
    int i = indexFor(hash, table.length);
    // 如果 key 相同修改对应的key的值，返回以前的值
    for (Entry<K,V> e = table[i]; e != null; e = e.next) {
        Object k;
        if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
            V oldValue = e.value;
            e.value = value;
            e.recordAccess(this);
            return oldValue;
        }
    }
	// 判断修改次数(为了防止并非异常)
    modCount++;
    addEntry(hash, key, value, i);
    return null;
}

final int hash(Object k) {
    int h = hashSeed;
    if (0 != h && k instanceof String) {
        return sun.misc.Hashing.stringHash32((String) k);
    }
    // hashSeed = 0 ，异或：不相同为1
    h ^= k.hashCode();

    // This function ensures that hashCodes that differ only by
    // constant multiples at each bit position have a bounded
    // number of collisions (approximately 8 at default load factor).
    // 让高位也能参加hash生成，让hashcode更加散列
    h ^= (h >>> 20) ^ (h >>> 12);
    return h ^ (h >>> 7) ^ (h >>> 4);
}

static int indexFor(int h, int length) {
    // assert Integer.bitCount(length) == 1 : "length must be a non-zero power of 2";
    // &相同为1，因为length是2的幂次方数，所以减一以后&方法就能使计算出来的index平均切不越界
    return h & (length-1);
}

void addEntry(int hash, K key, V value, int bucketIndex) {
        // 扩容
        if ((size >= threshold) && (null != table[bucketIndex])) {
            resize(2 * table.length);
            hash = (null != key) ? hash(key) : 0;
            bucketIndex = indexFor(hash, table.length);
        }
        // 头插法
        createEntry(hash, key, value, bucketIndex);
    }
```



### get方法

```java
public V get(Object key) {
if (key == null)
// 如果key等于null，直接从数组的第0个位置找
return getForNullKey();
Entry<K,V> entry = getEntry(key);

return null == entry ? null : entry.getValue();
}

final Entry<K,V> getEntry(Object key) {
    if (size == 0) {
        return null;
    }
    // 计算Key的hash值
    int hash = (key == null) ? 0 : hash(key);
    // 找到key在table的位置，迭代找出符合key的value
    for (Entry<K,V> e = table[indexFor(hash, table.length)];
         e != null;
         e = e.next) {
        Object k;
        if (e.hash == hash &&
            ((k = e.key) == key || (key != null && key.equals(k))))
            return e;
    }
    return null;
}
```



## jdk1.8

### put方法

### get方法

