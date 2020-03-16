class Solution {
    public int lengthOfLIS(int[] nums) {
        // 状态转移方程：
        // 问题：找出从下标0到i为结尾的最大上升子序列的个数
        // 子问题： 下标0到i为结尾的最大上升子序列是 以 下标0到i-1最大上升子序列数 + 1
        // 转移方程： F(N)= F(N-1)+ 1
        // 求解： Max(F(N)
        if (nums.length == 0) return 0;

        int L = nums.length;
        int[] F = new int[L];
        F[0] = 1;
        int maxans = 1;
        for (int i = 1 ; i < L; i++){
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