class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int i = 0;
        for (int j = 0; i < nums.length; j++) {
            int transNum = j;
            int transValue = nums[j];
            do {
                int nextNum = (transNum + k) % nums.length;
                int nextValue = nums[nextNum];
                nums[nextNum] = transValue;
                transValue = nextValue;
                transNum = nextNum;
                i++;
            } while (j != transNum);
        }
    }
}
