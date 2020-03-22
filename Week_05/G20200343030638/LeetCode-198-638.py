class Solution:
    def rob(self, nums: List[int]) -> int:
        pre_max = 0
        cur_max = 0

        for num in nums:
            tmp = cur_max
            cur_max = max(pre_max + num, cur_max)
            pre_max = tmp
        
        return cur_max