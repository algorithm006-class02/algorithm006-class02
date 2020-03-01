# https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/submissions/

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) == 0 : return 0
        tail = 0
        for fast in range(1,len(nums)):
            if nums[tail] != nums[fast]:
                tail += 1
                nums[tail] = nums[fast]
        return tail+1
