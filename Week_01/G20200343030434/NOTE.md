# 学习笔记
## PriorityQueue
### 使用
PariorityQueue 是可以根据优先级存取的数据结构，java api中通过heap实现
### 优先级确定
The elements of the priority queue are ordered according to their natural ordering, or by a Comparator provided at queue construction time, depending on which constructor is used.
### 示例代码
```java
//Employee(level,name,time)
Comparator<Employee> nameSorter = Comparator.comparing(Employee::getName);
 
PriorityQueue<Employee> priorityQueue = new PriorityQueue<>( nameSorter );
         
priorityQueue.add(new Employee(1l, "AAA", LocalDate.now()));
priorityQueue.add(new Employee(4l, "CCC", LocalDate.now()));
priorityQueue.add(new Employee(5l, "BBB", LocalDate.now()));
priorityQueue.add(new Employee(2l, "FFF", LocalDate.now()));
priorityQueue.add(new Employee(3l, "DDD", LocalDate.now()));
priorityQueue.add(new Employee(6l, "EEE", LocalDate.now()));
 
while(true) 
{
    Employee e = priorityQueue.poll();
    System.out.println(e);
     
    if(e == null) break;
}
```
上述代码使用Comparator确定优先级，会按name排序打印employee对象信息。
### 源码解读
#### constructor
```java
    public PriorityQueue(int initialCapacity,
                         Comparator<? super E> comparator) {
        if (initialCapacity < 1)
            throw new IllegalArgumentException();
        this.queue = new Object[initialCapacity];
        this.comparator = comparator;
    }
```
标准构造方法创建一个空**initialCapacity**大小的Object数组。并设置传入的**comparator**
#### add
下面代码是pariorityQueue 增加元素的核心代码
```java
    private void siftUp(int k, E x) { //k:原堆大小 x:新增加到堆的对象
        if (comparator != null)
            siftUpUsingComparator(k, x); //使用comparator
        else
            siftUpComparable(k, x); //不实用comparator
    }

    @SuppressWarnings("unchecked")
    private void siftUpComparable(int k, E x) { 
        Comparable<? super E> key = (Comparable<? super E>) x;
        while (k > 0) {
            int parent = (k - 1) >>> 1; //获取父节点位置 (k-1)/2 
            Object e = queue[parent];
            if (key.compareTo((E) e) >= 0) //默认情况下 父亲节点已经小于子节点，说明已经放到正确位置。
                break;
            queue[k] = e; //将原本parent对象下沉
            k = parent; //缩小下次判断范围
        }
        queue[k] = key; //将对象放到何时位置
    }

    @SuppressWarnings("unchecked")
    private void siftUpUsingComparator(int k, E x) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            if (comparator.compare(x, (E) e) >= 0)
                break;
            queue[k] = e;
            k = parent;
        }
        queue[k] = x;
    }
```
从源码中默认使用
```java
            if (key.compareTo((E) e) >= 0)
                break;
```
* 可以看出默认priorityQueue是使用小顶堆来构建的,如果想实现大顶堆只要相应的修改comparable即可。
* 同时可以看出 java是使用数组的方式构建的小顶堆，构建方式是利用树的中序遍历。因此父节点是 **(k-1)/2**
#### peek
获取堆顶元素
在数组中就是获取数组第一个元素
```
    public E peek() {
        return (size == 0) ? null : (E) queue[0];
    }
```
#### contains
```java
    private int indexOf(Object o) {
        if (o != null) {
            for (int i = 0; i < size; i++)
                if (o.equals(queue[i]))
                    return i;
        }
        return -1;
    }
```
contains其实就是遍历数组判断是否在数组中O(n) 由于数组不是有序的因此不能优化为O(logn)
#### remove
删除堆中的元素
```java
    public boolean remove(Object o) {
        int i = indexOf(o);
        if (i == -1)
            return false;
        else {
            removeAt(i);
            return true;
        }
    }
```
* 上述代码遍历数组获得要删除对象的数组下标
```java
    private E removeAt(int i) {
        // assert i >= 0 && i < size;
        modCount++;
        int s = --size;
        if (s == i) // removed last element
            queue[i] = null;
        else {
            E moved = (E) queue[s];
            queue[s] = null;
            siftDown(i, moved);
            if (queue[i] == moved) {
                siftUp(i, moved);
                if (queue[i] != moved)
                    return moved;
            }
        }
        return null;
    }
```
* 通过siftDown siftUp 删除对象 //todo 有待补充

