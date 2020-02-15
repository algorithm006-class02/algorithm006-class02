学习笔记

* 用 add first 或 add last 这套新的 API 改写 Deque 的代码
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
* 分析 Queue 的源码


* 分析 Priority Queue 的源码

