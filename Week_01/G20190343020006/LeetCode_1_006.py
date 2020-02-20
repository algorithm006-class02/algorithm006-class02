class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        temp_list = sorted(range(len(nums)),key = lambda x:nums[x])
        a = 0
        b = len(nums) - 1
        while a < b:
            result = nums[temp_list[a]] + nums[temp_list[b]]
            if result == target:
                return [temp_list[a],temp_list[b]]
            elif result < target:
                a += 1
            elif result > target:
                b -= 1
