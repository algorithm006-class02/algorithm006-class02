class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
  '''      if len(nums) == 0:
            return 0
        i = 0
        for j in range(1,len(nums)):
            if nums[j] == nums[i]:
                i += 1
                nums[i] = nums[j]
            
        return i+1 '''
        for index in xrange(len(nums)-1,0,-1):
            if nums[index] == nums[index-1]:
                nums.pop(index)
        return len(nums)
