def subsets(self, nums):
    """
    :type nums: List[int]
    :rtype: List[List[int]]
    """

    def back(tmp, index, nums):
        if index == len(nums):
            res.append(tmp)
            return res

        back(tmp+[nums[index]], index+1, nums)
        back(tmp, index+1, nums)

    res = []
    back([], 0, nums)
    return res