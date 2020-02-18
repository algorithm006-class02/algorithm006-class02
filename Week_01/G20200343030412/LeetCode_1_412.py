class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # 哈希表
        dict = {}
        for i in range(len(nums)):
            x = nums[i]
            if target - x in dict:
                return (dict[target - x], i)  # 返回对应值的索引和当前的索引也就是得出target值的两个数的索引
            dict[x] = i  # 将备选值及索引作为键值对放到dict中
