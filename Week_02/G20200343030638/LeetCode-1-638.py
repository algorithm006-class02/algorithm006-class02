class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}
        for i,num in enumerate(nums):
            if hashmap.get(target - num) is not None:
                return [hashmap[target - num], i]
            hashmap[num] = i