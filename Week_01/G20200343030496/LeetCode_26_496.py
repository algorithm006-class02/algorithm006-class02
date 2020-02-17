
#已经排好序，重点信息
class Solution:
    #method 1 哈哈好简单
    def removeDuplicates1(self, nums: [int]) -> int:
        if not nums: return 0
        k = 1
        for i in range(1, len(nums)):
            if nums[i] != nums[i - 1]:
                nums[k] = nums[i]
                k += 1
        print(1,nums)
        return k

    #method2 逻辑更完整
    def removeDuplicates2( self,nums):
        if not nums:
            return 0
        if len(nums) == 1:
            return 1
        k = 1
        now = nums[0]
        for i in range(1, len(nums)):
            if nums[i] == now:
                continue
            #互换位置
            nums[k], nums[i] = nums[i], nums[k]# 1,0
            now = nums[k]
            k += 1
        print(nums)
        return k

s = Solution()
b = [0,0,1,1,1,2,2,3,3,4,]
print(s.removeDuplicates1(b))