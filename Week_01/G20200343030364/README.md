#  Summary

## Queue

Search API：queue java 10

Queue is a interface in java. Abstract methods are: 

`add` `remove` `element` these mehtods will throw Exception, when some condition is violated.

`off` `poll` `peek` are counterparts methods, these methods will not throw Exception.

![2020-02-15_000.jpg](https://gitee.com/gdhu/testtingop/raw/master/2020-02-15_000.jpg)

## Deque

Deque java 13 [deque](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/Deque.html)

![2020-02-15_001.jpg](https://gitee.com/gdhu/testtingop/raw/master/2020-02-15_001.jpg)

![2020-02-15_002.jpg](https://gitee.com/gdhu/testtingop/raw/master/2020-02-15_002.jpg)

![2020-02-15_003.jpg](https://gitee.com/gdhu/testtingop/raw/master/2020-02-15_003.jpg)

## Priority Queue

Priority Queue: An unbounded priority [queue](https://docs.oracle.com/javase/10/docs/api/java/util/Queue.html) based on a priority heap.

Implementation note: this implementation provides O(log(n)) time for the enqueuing and dequeuing methods (`offer`, `poll`, `remove()` and `add`); linear time for the `remove(Object)` and `contains(Object)` methods; and constant time for the retrieval methods (`peek`, `element`, and `size`).

[priority queue java 10](https://docs.oracle.com/javase/10/docs/api/java/util/PriorityQueue.html)

The queue is stored in a binary balance heap which is an array.

They **key** is **heapify** by `shfit` which means element move up and down in the tree.

About source code in java:

```java
    /**
     * Establishes the heap invariant (described above) in the entire tree,
     * assuming nothing about the order of the elements prior to the call.
     * This classic algorithm due to Floyd (1964) is known to be O(size).
     */
    private void heapify() {
        final Object[] es = queue;
        int n = size, i = (n >>> 1) - 1;
        final Comparator<? super E> cmp;
        if ((cmp = comparator) == null)
            for (; i >= 0; i--)
                siftDownComparable(i, (E) es[i], es, n);
        else
            for (; i >= 0; i--)
                siftDownUsingComparator(i, (E) es[i], es, n, cmp);
    }
```

For the detail, I would refer to Algorithm 4 later.