class Solution {
    ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
    int[] nums;

    public void clean_deque(int i, int k) {
        if (!deque.isEmpty() && deque.getFirst() == i - k)
            deque.removeFirst();
        while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) deque.removeLast();
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;
        this.nums = nums;
        int max_index = 0;
        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            deque.addLast(i);
            if (nums[i] > nums[max_index]) max_index = i;
        }
        int[] output = new int[n - k + 1];
        output[0] = nums[max_index];
        for (int i = k; i < n; i++) {
            clean_deque(i, k);
            deque.addLast(i);
            output[i - k + 1] = nums[deque.getFirst()];
        }
        return output;
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n - k + 1];
        int ri = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }

}