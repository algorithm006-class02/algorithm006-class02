
学习笔记

一、数组
1.数组：在计算机存储中是一段连续的地址，每个地址都可以通过内存管理器直接访问
优点：随机访问的时候时间复杂度O(1)
缺点：插入、删除元素的时候时间复杂度O(n)

2.相对于JDK中是 ArrayList 的结构，在 add 的时候会判断容量是否足够，不够的话会会扩容2倍 ensureCapacity，期间扩容和后移/前移操作都是System.arraycopy 来拷贝

3.数组基本操作时间复杂度
prepend O(1)
append O(1)
lookup O(1)
insert O(n)
delete O(n)

二、链表
1.链表：由一个一个节点连接一起，相比于数组对于频繁插入、删除的时候我们会使用链表
优点：插入、删除时间复杂度都O(1)
缺点：随机访问的时间复杂度O(n)
Node包含value/next/previous是双向链表，头指针用Head表示、尾指针用Tail表示，最后一个next指向null

2.相对于JKD中是 LinkedList 的结构，它的结构是双向链表，在Entry中有一个Entry next和Entry previous，在外层成员变量维护这first和last头尾指针和size这个链表的大小

3.链表基本操作时间复杂度
prepend O(1)
append O(1)
lookup O(n)
insert O(1)
delete O(1)

三、跳表
1.跳表：在Redis中有应用，跳表是为了优化链表的随机访问的缺陷而产生的

2.如何给链表加速？
方法一：添加头尾指针，这样在查询头尾节点的时候O(1)时间就可以拿出
方法二：中心思想就是升维，空间来换取时间，基于方法一就可以扩展了，我多添加一些指针

3.通过给链表加速，我们不断给中间插入指针，中间的中间.....持续下去（所以每层索引遍历的节点个数是3），那么第一级索引就建立出来了，原始链表速度是1，一级索引速度就是2，然后同理建立二级索引相对于原始链表跨4个元素，速度是4，以此类推增加多级索引

4.一共有n个元素，需要增加log2^n-1个级索引证明，跳表查询时间时间复杂度等于层数所以为log2^n
证明推理：链表有n个第一级索引是n/2个元素，第二级是n/4,第h级是n/2^h
假设索引有h级，最高的索引有2个节点则有 n/2^h = 2 退出 h=log2^n-1,同理假设最高层索引有一个则需要建立 log2^n层索引

5.跳表空间复杂度
原始链表大小为n，每2个结点抽1个，每层索引的结点数： n/2,n/4,n/8...4,2
原始链表大小为n，每3个结点抽1个，每层索引的结点数： n/3,n/9,n/27...4,2
空间复杂度为O(n) 数量级是n 收敛起来还是n

四、缓存
1.缓存：这里说的缓存是一种广义的概念，在计算机存储层次结构中，低一层的存储器都可以看做是高一层的缓存。缓存之所以有效是因为程序和数据的局部性（locality），程序会按固定的顺序执行，数据会存放在连续的内存空间并反复读写。

2.LRU-Cache最近最少使用（LRU，Least Recently Used）
简书：LRU实现 hashmap+双向链表 <https://www.jianshu.com/p/b1ab4a170c3c>

3.为什么Redis用跳表而不用红黑树
并发场景下红黑树要锁多个节点比较复杂
排序集合通常使用zrange和zrevrange
便于实现、调试

dubbo LinkedList 实现LRU-Cache

五、栈
Stack：先入后出；添加、删除都是O(1)；查询是O(n)
基本方法：
boolean empty():判断这个栈是否为空
E peek()：查看栈顶元素
E pop()：删除栈顶元素
E push(E item) ：从栈顶入栈
int search(Object o)：查询一个元素在stack的下标

六、队列
Queue：先入先出；添加、删除都是O(1)，在Java中是接口下面的子类有很多如：LinkedList、LinkedBlockingQueue、DelayQueue、PriorityQueue等
基本方法：
插入 抛异常的add(e)/返回特殊值的 offer(e)
删除 抛异常的remove()/返回特殊值的poll()
访问元素 抛异常的element()/返回特殊值peek()

七、双端队列
Deque（Double-ended Queue）：双端队列，可以从前后添加和删除元素；添加、删除都是O(1) 查询O(n)，在Java中实现有ArrayDeque，ConcurrentLinkedDeque，LinkedBlockingDeque，LinkedList
基本方法：
从头部操作 从尾部操作
抛异常 特殊值 抛异常 特殊值
插入 addFirst(e) offerFirst(e) addLast(e) offerLast(e)
删除 removeFirst() pollFirst() removeLast() pollLast()
访问元素 getFirst() peekFirst() getLast() peekLast()

八、优先队列
PriorityQueue 插入操作O(1)、去除操作O(logn)按照元素的优先级取出，保证了一定的有序性，底层实现可以是heap、bst、treap,必须要实现comparator方法就是比较大小用于保证有序
基本方法：
boolean add(E e)：添加元素
void clear()：清空优先队列
boolean offer():添加元素
boolean remove(Object o) :删除元素
poll/peek

九、对于Queue和PriorityQueue分析
对于Queue来说很简单它只是一个接口，主要有add添加抛异常、remove移除头元素、element返回头元素、offer添加返回特殊值、poll移除头元素、peek返回头元素，前面的会抛出异常而后面的几个会返回特殊值
Queue主要的实现类有ArrayBlockingQueue、ArrayDeque、ConcurrentLinekedQueue、ConcurrentLinekedDeque、DelayQueue、LinkedList、LinkedBlockingQueue、LinkedBlockingDeque、PriorityQueue等。

ArrayBlockingQueue举例核心成员变量有：

- 元素数组Object[] items
- 放入队头元素的下标 takeIndex
- 拿走队尾元素的下标 putIndex
- 队列元素数量 count

对于并发和锁的方面主要有：

- ReentrantLock 可重入锁 具有对中断有响应、可限时、可公平锁的特点
- 2个Condition 用于控制放入和拿走元素的条件 实现线程间的协调

对于PriorityQueue他是属于Queue的一种实现，底层结构使用数组，初始化大小为11个
在初始化的时候首先会heapify构建这个堆，在插入的时候会siftUp调整这个堆以保证每次拿出来
对顶元素都是最小值，在出队列的时候会shiftDown然后将最后一个元素放到0位置整体在向下进行调整使得再次成为堆

十、改写Deque

```
    Deque<String> deque = new LinkedList<>();

    deque.addFirst("a");
    deque.addFirst("b");
    deque.addLast("c");
    System.out.println(deque);
    String peek = deque.peek();
    System.out.println(peek);
    System.out.println(deque);
    while (deque.size() > 0) {
        System.out.println(deque.pop());
    }
    System.out.println(deque);
```
=======
#学习笔记
##内容总结
    本周主要学习了基本的数据结构，譬如数组，链表，栈以及队列等等，以及这些数据结构的一些操作。首先对于常见数据结构的时间和空间复杂度，都进行了理清和熟悉，尤其是对于数组和链表的插入删除，以及查询的复杂度有了新的认知。
    此外，对于跳表，之前在其他方面的学习中接触很少，明白了以空间换时间的思路，针对链表查询慢的缺点从而设计的跳表，其核心思想就是通过索引的方法进行“加速”，从而使时间复杂度降到O（logN）级别，尽管在空间复杂度上有所提升，但是在工程上确实能够有助于高性能程序的优化，毕竟现在存储价格不再像以前那么昂贵。栈和队列在大学学习阶段只是有一个FIFO这种粗浅的概念，而具体的使用在之后的工程中遇到的不多，这次通过学习还了解到了双端队列的概念，并对这些数据结构常见的操作的复杂度，以及应用有了一定的认识。
##学习心得
“五毒神掌”+听课的结合，是本周最大的收获之一，有些内容可能初听感觉还是有不明白的地方，但是听完课然后自己亲自动手写一遍并且背诵理解之后，在进行反复的训练之后，就逐渐能够理解一些算法中原本不理解的地方，这是本次的学习中所获得进步。另外，通过自己的学习情况，我这边在第二遍以及第三遍刷题的时候，结合了之前同学的学习建议，使用iPad+Onenote的方式，将已经刷过的题目再刷题之后在进行默写一次并进行整理总结，目前看来效果还不错，希望到四刷以及面试前的五刷的时候，能够有进一步强化的效果。
