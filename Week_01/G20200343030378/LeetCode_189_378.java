public class LeetCode_189_378 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        //注意旋转顺序
        turn(nums,0,nums.length-1);
        turn(nums,0,k-1);
        turn(nums,k,nums.length-1);
    }

    private void turn(int[] nums, int l, int r) {
        while (l<r){
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
}
