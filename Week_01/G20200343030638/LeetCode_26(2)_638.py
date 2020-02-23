class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        for i in range(len(nums))[::-1]: 
            if i > 0:
                if nums[i-1] == nums[i]:
                    del nums[i]
        return len(nums)