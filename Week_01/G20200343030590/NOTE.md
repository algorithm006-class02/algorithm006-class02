学习笔记

# 分析Queue和Priority Queue的源码

- 首先Queue的基本操作有add、offer、remove、poll、element、peek，而再看Priority Queue他增加了哪些能力
  - 除了offer、peek、remove、poll这些，还增加了遍历、扩容和比较器这些功能
  - 虽然Priority Queue是无界的，但是内部存放元素采用数组，可以实现自动扩容；而queue只是一个接口，一个协议，内部实现由使用者自己定义和扩展
  - 如果在多线程场景下使用Priority Blocking Queue
  - 时间复杂度：poll，offer，remove()和add操作是O(log(n))，remove(object)和contains(object)，还有检索操作peek、element和size都是线性的
  
- 再看一些全局变量和内部的参数设置
  - 默认的数组大小是11，也即是可以无参构造器初始化的Priority Queue是大小11，以自然序排列的队列
  - modCount和List一样，在扩容时使用的判定大小的变量
  - 可以通过Collection类型的容器和另一个Priority Queue来初始化
    - 这里主要看下堆化函数heapify，虽然源码的可读性不是很强，但是包含了大量的位运算还是值得对性能有要求的同学学习下，代码segment如下：
  ```
  private void siftDownUsingComparator(int k, E x) {
          int half = size >>> 1;
          while (k < half) {
              int child = (k << 1) + 1;
              Object c = queue[child];
              int right = child + 1;
              if (right < size &&
                  comparator.compare((E) c, (E) queue[right]) > 0)
                  c = queue[child = right];
              if (comparator.compare(x, (E) c) <= 0)
                  break;
              queue[k] = c;
              k = child;
          }
          queue[k] = x;
      }
  ```
  无论采用了初始化时的comparator还是Comparable接口，都是类似的建堆操作，k是即将填入元素的位置，x是插入的元素。先推算出子节点的位置，然后
  创建子堆，与右子堆的元素比较，大于则放入子节点。只到小于才退出。  
  - 接下来看grow方法，他是用于给内部数组扩容的工具。这里采用了比最大整数还小的size防止OOM错误导致内存崩溃退出。调整好容量后采用数组拷贝将整个队列
  搬移到新的容量中
  - 前面讲到的offer操作是O(long(n))，可以明确是哪里的操作拖慢了速度，因为每次进行offer元素时都会执行小顶堆的插入操作，而二叉堆的复杂度为O(long(n)).
  参考如下代码：
  ```
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
- 关于内部数组部分和ArrayList是类似的