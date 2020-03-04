class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        if(len(nums)==0):
            return
        k=k%len(nums)
        for i in range(0,k):
            nums.insert(0, nums[-i-1])
        for i in range(0,k):
            del nums[-1]