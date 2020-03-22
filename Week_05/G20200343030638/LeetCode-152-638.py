class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        n = len(nums)
        max_num = float("-inf")
        imax = 1
        imin = 1

        for i in range(n):
            if nums[i] < 0:
               imax, imin = imin, imax
                
            imax = max(imax*nums[i], nums[i])            
            imin = min(imin*nums[i], nums[i])

            max_num = max(max_num, imax)

        return max_num