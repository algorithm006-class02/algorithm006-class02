class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        zero = 0
        n = len(nums) 
        for i in range(n):
            if nums[i]:
                nums[zero] = nums[i]
                zero += 1
                
        nums[zero:] = [0] * (n - zero)