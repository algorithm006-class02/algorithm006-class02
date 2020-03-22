class Solution {
    public boolean canJump(int[] nums) {
      int i = nums.length - 1;
      for (int j = nums.length - 1; j >= 0 ; j--){
          if (j + nums[j] >= i){
              i = j;
          }
      }
      return i == 0;
    }
}
