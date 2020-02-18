//暴力方式 每次移动一位
class Solution {
    public void rotate(int[] nums, int k) {
        for (int i = 1; i <= k; i++) {
            int lastNum = nums[nums.length - 1];
            for (int j =  nums.length -1; j > 0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = lastNum;
        }
    }
}

//反转
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse (int[] nums, int start, int end){
        int reverseNum = (end - start + 1) / 2;
        for (int i = 1; i <= reverseNum; i++) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end--;
        }
    }
}
