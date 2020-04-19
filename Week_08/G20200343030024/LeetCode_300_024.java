class Solution {
    public int lengthOfLIS(int[] nums) {
                if (nums.length == 0) return 0;

        int[] F = new int[nums.length];
        int maxans = 0;
        F[0] = 1;

        for (int i = 0; i < nums.length; i++){
            int maxval = 0;
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    maxval = Math.max(maxval, F[j]);
                }
            }
            F[i] = maxval + 1;
            maxans = Math.max(maxans, F[i]);
        }


        return maxans;
    }
}