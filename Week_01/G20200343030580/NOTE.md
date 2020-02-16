学习笔记

### 用 add first 或 add last 这套新的 API 改写 Deque 的代码
````
        Deque<String> deque = new LinkedList<String>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);
        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
````
### 分析 Queue 的源码

Java中Queue是一个继承了Collection的接口。已知的子接口有BlockingDeque，BlockingQueue，Deque，TransferQueue等接口。已知的实现类有
AbstractQueue, ArrayBlockingQueue, ArrayDeque, ConcurrentLinkedDeque, ConcurrentLinkedQueue, DelayQueue, LinkedBlockingDeque, LinkedBlockingQueue, LinkedList, LinkedTransferQueue, PriorityBlockingQueue, PriorityQueue, SynchronousQueue。     

#### Queue的主要方法有：
* boolean add(E e); //向队列添加一个元素，如果由于队列满了无法插入，则抛出IllegalStateException。
* boolean offer(E e); //向队列添加一个元素，如果队列满了无法插入，则返回false。在队列长度有限制的情况下，优先使用offer方法。
* E remove(); //获取队列的第一个元素，并在队列中将其移除。如果队列是空的，则抛出NoSuchElementException异常。
* E poll(); //获取队列的第一个元素，并在队列中将其移除。如果队列是空的，则返回null。
* E element(); //获取队列的第一个元素。如果队列是空的，则抛出NoSuchElementException异常。
* E peek(); //获取队列的第一个元素。如果队列是空的，则返回null。

#### ArrayBlockingQueue的源码分析：  
ArrayBlockingQueue是一个基于数组实现的有边界的（固定长度）的阻塞队列。队列是以FIFO的顺序排列元素。是一个典型的"bounded buffer"，常用于基于固定大小元素的生产者消费者模式。  
在多线程的场景下，对于在等待中的生产者和消费者线程，此类还提供了一个公平策略。在公平模式下，不同线程对于队列的访问优先级是FIFO。

##### 构造函数：
ArrayBlockingQueue提供三个构造函数：
* public ArrayBlockingQueue(int capacity);//capacity 队列的长度
* public ArrayBlockingQueue(int capacity, boolean fair);//fair 多线程访问的情况下，是否遵循访问者FIFO。false代表不保证
* public ArrayBlockingQueue(int capacity, boolean fair,
                                Collection<? extends E> c);//c是队列初始化的时候添加的元素。
                                
fair的实现方式是通过ReentrantLock。本处暂时不做具体分析。

##### 存储&关键属性
ArrayBlockingQueue的元素存储在一个数组中final Object[] items;  实际上items使用起来，效果和一个循环链表的使用效果一样。
使用一个计数器来存储当前队列中的元素的数量。int count;  
下一个插入元素所处的index，int putIndex;
下一个获取元素所处的index，int takeIndex;

##### 关键方法的实现

###### boolean add(E e)
此方法在实现过程中是调用了boolean offer(E e)实现的。

###### boolean offer(E e)
offer方法的流程很简单
* check元素空指针
* 加锁
* 判断队列是否满，满了的话，枷锁&返回false
* 队列未满，调用void enqueue(E x);
* 解锁&返回true

###### void enqueue(E x)

* 将x插入到items[putIndex]
* putIndex自增1
* 如果自增1之后的putIndex和items的长度相等，也就是putIndex数组越界，则将putIndex赋值为0。这样做，实际上试将items数组作为一个循环链表在使用。
* 队列的元素数+1，也就是count++;
* notEmpty.signal();先不做分析。用于实现从队列中获取元素阻塞特性。

###### void put(E e) throws InterruptedException

向队列中插入一条元素，如果队列满了，则阻塞，等待队列释放空间，再调用调用void enqueue(E x);

###### boolean offer(E e, long timeout, TimeUnit unit)

向队列中插入一条元素，如果队列满了，则阻塞，等待队列释放空间，再调用调用void enqueue(E x);超过了超时时间，插入失败，返回false。

###### E poll()

实现流程比较简单，不再赘述。具体调用了E dequeue()方法。

###### E dequeue()

* 将要被取出的元素是items[takeIndex]。
* 将items[takeIndex]设置为null，便于垃圾回收机制起到效果。
* takeIndex的处理方式同putIndex，也就是自增1，如果自增之后数组越界了，则将takeIndex。
* 对于Itrs暂不做分析。

######  E take() 

获取队列中的元素，如果队列是空的，则阻塞，等待新的元素加进队列。再调用E dequeue()获取。

###### E poll(long timeout, TimeUnit unit) throws InterruptedException

获取队列中的元素，如果队列是空的，则阻塞，等待新的元素加进队列。再调用E dequeue()获取。超过了超时时间，获取失败，返回null。

###### E peek()

在加锁，解锁操作之间，直接返回items[takeIndex]

##### 小结

使用一个数组存储元素，使用两个指针来插入和获取数据，数组的使用就像循环链表。  
使用ReentrantLock来控制并发。


### 分析 Priority Queue 的源码

java.util.PriorityQueue是一个无边界的基于priority heap存储的priority queue。PriorityQueue的元素是按照自然顺序或者Comparator的算法指定的顺序排序的。

#### 构造函数
PriorityQueue提供了7个构造函数：
* public PriorityQueue();//以DEFAULT_INITIAL_CAPACITY为初始化大小的队列。DEFAULT_INITIAL_CAPACITY = 11。
* public PriorityQueue(int initialCapacity);//设置了初始化大小。
* public PriorityQueue(Comparator<? super E> comparator);//设置了comparator。
* public PriorityQueue(int initialCapacity,
                           Comparator<? super E> comparator);//设置初始化大小和comparator。
* public PriorityQueue(Collection<? extends E> c);//用一个Collection初始化队列里的元素。
* public PriorityQueue(PriorityQueue<? extends E> c);//用另外一个PriorityQueue初始化队列里的元素。
* public PriorityQueue(SortedSet<? extends E> c);//用一个SortedSet初始化队列里的元素。

#### 存储&关键属性

* Object[] queue;
* int size; 队列里的元素数量。
* Comparator<? super E> comparator; 比较器，也可以为空。
* int modCount; 队列被操作的次数。

#### 关键的方法的实现

##### boolean add(E e)

是调用boolean offer(E e)方法来实现的。

##### boolean offer(E e)

关键的操作：
* modCount++
* 如果size（也就是队列的大小）大于了Object[] queue，就需要先扩容，扩容是调用void grow(int minCapacity)方法来实现的。
* 如果队列是空的，则将e塞进queue[0]。
* 否则，调用void siftUp(int k, E x);重新调整heap。

##### E peek()

如果队列不为空，则返回queue[0]。

##### E poll()

* 如果队列为空，返回null
* modCount++
* 取出queue[0]
* 重新调整heap。