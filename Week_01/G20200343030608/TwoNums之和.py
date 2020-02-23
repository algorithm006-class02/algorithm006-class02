class Solution:
    def twoSum_One(self, nums: List[int], target: int) -> List[int]:
        num2 = []
        for i in range(len(nums)-1):
            for j in nums:
                if (nums[i] + nums[j] == target):
                    num2[0] = i
                    num2[1] = j
                    return num2



    def twoSum_Two(self, nums: List[int], target: int) -> List[int]:
        num2index = {}
        for i,j in enumerate(nums):
            if j in num2index:
                return [num2index.get(j),i]
            num2index[target - j] = i

