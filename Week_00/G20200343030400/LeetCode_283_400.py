//283-move-zeros

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        count_nonzeros = 0
        for i in range(len(nums)):
            if nums[i] != 0 :
                if i > count_nonzeros :
                    nums[count_nonzeros] = nums[i]
                    nums[i] = 0
                count_nonzeros += 1 
