class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        n = len(nums)
        j = 0
        for i in range(1, n):
            if nums[j] != nums[i]:
                j += 1
                if j != i:
                    nums[j] = nums[i]
        return j + 1