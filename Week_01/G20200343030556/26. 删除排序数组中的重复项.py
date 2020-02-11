class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        # 法一：利用组成字典来去重
        # 内存说明：nums[:]使用的还是nums原来的内存，没有开辟新的内存空间
        # nums[:] = dict.fromkeys(nums).keys()
        # return len(nums)

        # 法二：快慢指针
        if nums is None: return 0
        size = len(nums)
        i = 0
        for j in range(1, size):
            if nums[j] != nums[i]:
                i, nums[i] = i + 1, nums[j]
        return len(nums)