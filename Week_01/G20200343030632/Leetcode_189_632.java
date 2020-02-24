
class Solution {
    public void rotate(int[] nums, int k) {
        rotate_v1(nums, k);
    }

    public void rotate_v1(int[] nums, int k) {
        
        for (int i = 0; i < k; i++) {
            int last_val = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = last_val;
        }
    }

    public void rotate_v2(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    private void reverse(int[] nums, int begin, int end) {
        while (begin < end) {
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }
}