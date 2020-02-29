class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        n = len(nums)
        maxn = n // 2
        sets = set(nums)
        
        for i in sets:
            count = nums.count(i)
            if count > maxn:
                return i