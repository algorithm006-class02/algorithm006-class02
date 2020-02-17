## 学习笔记

#### 移动0
一开始自己的想法：
在写之前的思路是查出0有多少，或者获取到非0数组，然后要么用非0数组，通过循环补0，或者在非0数组后add 0的数组
写出下面的代码
```
    public static void moveZeroes(int[] nums) {
        int l = nums.length;
        int[] arr = Arrays.stream(nums).filter(num -> num != 0).toArray();
        for (int i = 0; i < l; i++) {
            if (i <= arr.length - 1) {
                nums[i] = arr[i];
            } else {
                nums[i] = 0;
            }
        }
    }
```
通过看老师的指导和别人的题解，了解到了替换角标、通过第三个变量中转来替换等方法来解题。

而且在讲解时有提到使用自带方法append、remove时也应该考虑到调用方法在题目的环境里就拥有一个时间复杂度，不一定对解题会起到积极的作用，由此也引发了思考，尽量对调用方法的时间复杂度未知或者起不到积极作用的情况下，尽量不使用。

在后面几个讲解例子中可以了解到，任何一个题最起码都有一个暴力解法，满足题目的业务需求，但是一定有更优解。由此，其实也可以和五毒结合，第一遍写出最直接，最无脑的解法，第二遍优化自己的解法，第三遍看前几名的解法，理解之后，如果之前的解法通过调优可实现就再一次优化，若不能优化则修改自己的思路，按新的理解方式写出，至于三遍以后就开始不断重复，不断优化了。


#### Deque API 

```
    Deque<String> deque = new LinkedList<>();
    deque.addFirst("a1");
    System.out.println(deque);
    deque.addFirst("a2");
    System.out.println(deque);
    deque.addFirst("a3");
    System.out.println(deque);
    String first = deque.peekFirst();
    System.out.println(first);
    String last = deque.peekLast();
    System.out.println(last);
    System.out.println(deque);
    String removeFirst = deque.removeFirst();
    System.out.println(removeFirst);
    System.out.println(deque);
    String removeLast = deque.removeLast();
    System.out.println(removeLast);
    System.out.println(deque);
```