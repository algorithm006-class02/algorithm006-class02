# Queue 和 Priority Queue源码分析

## 1.Queue

Queue是一个接口，接口中定义的方法有6个：

| Method      | Return                               | Throws                                         |
| ----------- | ------------------------------------ | ---------------------------------------------- |
| add(E e);   | 如果添加成功返回一个true             | Throws exception                               |
| offer(E e); | 如果添加成功返回一个true             | Returns special value（如果添加失败返回false） |
| remove();   | 移除队列头元素，移除成功返回这个元素 | Throws exception                               |
| poll();     | 移除队列头元素，移除成功返回这个元素 | Returns special value（如果没有元素返回Null）  |
| element();  | 查看头元素，返回队列头元素           | Throws exception                               |
| peek();     | 查看头元素，返回队列头元素           | Returns special value（如果没有元素返回Null）  |



**Question：为什么逻辑一样的方法，要分一个抛出异常一个不抛异常？**

官网解释：

A collection designed for holding elements prior to processing. Besides basic [`Collection`](https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html) operations, queues provide additional insertion, extraction, and inspection operations. Each of these methods exists in two forms: one throws an exception if the operation fails, the other returns a special value (either `null` or `false`, depending on the operation). The latter form of the insert operation is designed specifically for use with capacity-restricted `Queue` implementations; in most implementations, insert operations cannot fail.

队列还提供附加的插入、提取和检查操作，这些方法中的每种都有两种形式：一个是抛出异常，一个是如果操作失败，另一个返回特殊值（NULL或FALSE，取决于操作）。后一种形式的插入操作专门设计用于容量受限的队列实现；在大多数实现中，插入操作不能失败。



## 2.Priority Queue

### Property：

| 名称                              | 描述                                                         |
| --------------------------------- | ------------------------------------------------------------ |
| int DEFAULT_INITIAL_CAPACITY = 11 | 默认的初始化容器长度                                         |
| Object[] queue                    | 队列使用数组保存数据                                         |
| Comparator<? super E> comparator  | 队列里面的元素使用的比较器，如果不指定，就是用元素自己默认的比较器 |
| int modCount = 0                  | 用于迭代器next和remove的时候判断是否数据仍然发生了结构化变更。迭代器在初始化时，拿一次当时的modCount，next和remove的时候，会判断旧的modCount和最新的modCount是否相同。如果不同会抛出ConcurrentModificationException |
| int size = 0                      | 队列的长度                                                   |



### Constructor ：

```java
// 默认构造函数，初始化容器大小为11
public PriorityQueue()
```

```java
// 初始化容器大小为传入的值
public PriorityQueue(int initialCapacity)
```

```java
// 默认容器大小为11，按照传入的比较器进行排序
public PriorityQueue(Comparator<? super E> comparator)
```

```java
// 初始化容器大小为传入的值，同时按照传入的比较器进行排序
public PriorityQueue(int initialCapacity, Comparator<? super E> comparator) 
```

```java
// 传入的是Collection父类，先判断是哪种类型，然后分别对不同的集合进行初始化处理
public PriorityQueue(Collection<? extends E> c) {
    /**
     * 1.设置comparator
     * 2.把里面的值设置给优先队列中的queue属性
     * 3.把数组的长度赋值给size
     */
    if (c instanceof SortedSet<?>) {
        SortedSet<? extends E> ss = (SortedSet<? extends E>) c;
        this.comparator = (Comparator<? super E>) ss.comparator();
        initElementsFromCollection(ss);
    }
    else if (c instanceof PriorityQueue<?>) {
        PriorityQueue<? extends E> pq = (PriorityQueue<? extends E>) c;
        this.comparator = (Comparator<? super E>) pq.comparator();
        initFromPriorityQueue(pq);
    }
    else {
        this.comparator = null;
        // 涉及建堆逻辑
        initFromCollection(c);
    }
}
```

```java
/**
 * 1.设置comparator
 * 2.把里面的值设置给优先队列中的queue属性
 * 3.把数组的长度赋值给size
 */
public PriorityQueue(SortedSet<? extends E> c)

// 如果是PriorityQueue则只需要设置数组和大小，如果是继承PriorityQueue的集合，需要重新建堆
public PriorityQueue(PriorityQueue<? extends E> c)

```

#### 分析建堆流程

```java
// 堆的结构可以分析：从最后一个节点的父节点开始构建堆
private void heapify() {
    // >>> 无符号右移
    for (int i = (size >>> 1) - 1; i >= 0; i--)
        siftDown(i, (E) queue[i]);
}

private void siftDown(int k, E x) {
    if (comparator != null)
        // 使用传入的比较器调整节点的位置
        siftDownUsingComparator(k, x);
    else
        // 使用默认的比较器（按照自然排序规则）调整节点的位置
        siftDownComparable(k, x);
}

private void siftDownComparable(int k, E x) {
    Comparable<? super E> key = (Comparable<? super E>)x;
    int half = size >>> 1;        // loop while a non-leaf
    while (k < half) {
        int child = (k << 1) + 1; // assume left child is least
        Object c = queue[child];
        int right = child + 1;
        if (right < size &&
            ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0)
            c = queue[child = right];
        if (key.compareTo((E) c) <= 0)
            break;
        queue[k] = c;
        k = child;
    }
    queue[k] = key;
}

private void siftDownUsingComparator(int k, E x) {
    // 找到最后一个节点的父节点
    int half = size >>> 1;
    // 如果k的位置大于父节点的位置，则退出循环
    while (k < half) {
        // 首先找到左右孩子中较小的那个，记录到c里，并用child记录其下标
        int child = (k << 1) + 1;
        Object c = queue[child];
        int right = child + 1;
        if (right < size &&
            comparator.compare((E) c, (E) queue[right]) > 0)
            c = queue[child = right];
        // 如果传入的值比C小，则退出本次循环
        if (comparator.compare(x, (E) c) <= 0)
            break;
        // 然后用c取代原来的值
        queue[k] = c;
        k = child;
    }
    queue[k] = x;
}
```



### Method：

#### add(E e) 和 offer(E e) 方法（add 方法调用了offer方法）

```java
public boolean add(E e) {return offer(e);}

public boolean offer(E e) {
    /**
     * 1.不能加入null元素
     * 2.修改操作加1
     * 3.是否需要扩容
     */
    if (e == null)
        throw new NullPointerException();
    modCount++;
    int i = size;
    if (i >= queue.length)
        grow(i + 1);
    size = i + 1;
    if (i == 0)
        queue[0] = e;
    else
        // 执行添加元素的方法
        siftUp(i, e);
    return true;
}

// 调用不同的比较器调整
private void siftUp(int k, E x) {
    if (comparator != null)
        siftUpUsingComparator(k, x);
    else
        siftUpComparable(k, x);
}

private void siftUpComparable(int k, E x) {
    Comparable<? super E> key = (Comparable<? super E>) x;
    while (k > 0) {
        int parent = (k - 1) >>> 1;
        // 保存父节点元素
        Object e = queue[parent];
        // 如果传入的节点大于父节点，退出循环
        if (key.compareTo((E) e) >= 0)
            break;
        // 如果传入的节点小于父节点，把这个父节点放在要被插入的位置
        queue[k] = e;
        // k等于父节点位置，以便和上一个父节点进行比较
        k = parent;
    }
    // 最后算出要插入节点的位置插入传入的节点
    queue[k] = key;
}

// 和上面的逻辑一致，就是使用了自己的比较器
private void siftDownUsingComparator(int k, E x)
```



####  **remove() 方法** 

```java
// 如果删除的元素不在数组中，返回false，如果在数组中就调用removeAt方法进行处理
public boolean remove(Object o)

private E removeAt(int i) {
    // assert i >= 0 && i < size;
    modCount++;
    // 如果i等于最后一个元素，直接移除
    int s = --size;
    if (s == i) // removed last element
        queue[i] = null;
    else {
        // 缓存最后一个元素
        E moved = (E) queue[s];
        queue[s] = null;
        // 先把最后一个元素和i位置的元素交换
        siftDown(i, moved);
        // 如果下调的位置没有变，说明该元素是该子树的最小元素，要进行上调
        if (queue[i] == moved) {
            // 执行上调方法
            siftUp(i, moved);
            // 上调后，如果i位置的值发生了改变，则返回该元素
            if (queue[i] != moved)
                return moved;
        }
    }
    return null;
}
```



#### poll()方法

```java
// 移除队列头元素
public E poll() {
    if (size == 0)
        return null;
    int s = --size;
    modCount++;
    // 缓存头元素
    E result = (E) queue[0];
    E x = (E) queue[s];
    queue[s] = null;
    if (s != 0)
        // 把最后一个元素放到头位置，然后进行下调
        siftDown(0, x);
    return result;
}
```



#### peek()方法

```java
// 返回头结点的值
public E peek() {
    return (size == 0) ? null : (E) queue[0];
}
```





