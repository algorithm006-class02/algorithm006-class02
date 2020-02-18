学习笔记
- 用 add first 或 add last 这套新的 API 改写 Deque 的代码
	```
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
	```
- 分析 Queue 和 Priority Queue 的源码
	- Queue的源码分析
		```
		public interface Queue<E> extends Collection<E> {
			// 添加一个元素，如果队列已满，则抛出异常
			boolean add(E e);

			// 添加一个元素，如果队列已满，则返回false
			boolean offer(E e);

			// 删除一个元素，如果队列为空，则抛出异常
			E remove();

			// 删除一个元素，如果队列为空，则返回null
			E poll();

			// 获取队头元素，如果队列为空，则抛出异常
			E element();

			// 获取队头元素，如果队列为空，则返回null
			E peek();
		}
		```
	- Priority Queue 的源码分析
		
		- Priority Queue底层是用堆实现的，堆是用数组实现的。
		
			这是内部的一个数组：
			```
			transient Object[] queue;
			```
		- 增加元素(可以看到有个siftUp(i, e)方法，就是重新构建堆的过程)
			```
			public boolean offer(E e) {
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
					// 这里会重新构建堆
					siftUp(i, e);
				return true;
			}
			```
		- 删除元素(可以看到，是删除index=0的元素，即堆的根，然后重新构建堆)
			```
			public E poll() {
				if (size == 0)
					return null;
				int s = --size;
				modCount++;
				E result = (E) queue[0];
				E x = (E) queue[s];
				queue[s] = null;
				if (s != 0)
					siftDown(0, x);
				return result;
			}
			```

- 一些学习心得
	- 遇到算法题没思路时，先看看能不能暴力求解。然后再看能不能根据简单的例子将问题泛化，找规律。
	- 有些编程题可以用哈希表来优化，比如LeetCode题目“[两数之和](https://leetcode-cn.com/problems/two-sum/)”，可以用哈希表保存遍历过的值，这样就可以少一次遍历，将时间复杂度优化为O(n)。
