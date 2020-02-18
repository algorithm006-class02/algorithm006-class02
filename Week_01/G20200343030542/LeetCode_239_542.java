import java.util.*;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return nums;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((n1, n2) -> n2 - n1);
        int[] ret = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            int j = i;
            int r = i + k - 1;
            if (i == 0) {
                while (j <= r) {
                    priorityQueue.add(nums[j]);
                    j++;
                }
            } else {
                priorityQueue.add(nums[r]);
            }
            ret[i] = priorityQueue.peek();
            priorityQueue.remove(nums[i]);
        }
        return ret;
    }

    public int[] maxSlidingWindowBruteForce(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return nums;
        }
        int[] ret = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k - 1; j++) {
                max = Math.max(max, nums[j]);
            }
            ret[i] = max;
        }
        return ret;
    }


    public int[] maxSlidingWindowSimple(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return nums;
        }
        //mp当前窗口的最大值的下标
        int mp = 0;
        int[] ret = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (i - mp >= k) {
                mp++;
                for (int j = mp + 1; j <= i; j++) {
                    mp = nums[j] >= nums[mp] ? j : mp;
                }
            }
            mp = nums[i] >= nums[mp] ? i : mp;
            if (i >= k - 1) {
                ret[index] = nums[mp];
                index++;
            }
        }
        return ret;
    }


    public int[] maxSlidingWindowWithDeque(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return nums;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ret = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= k - 1) {
                ret[index] = nums[deque.peek()];
                index++;
            }
        }
        return ret;
    }

}