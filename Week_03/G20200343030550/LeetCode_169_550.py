def majorityElement(nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    d = {}
    n = len(nums)/2
    for i in nums:
        if i not in d.keys():
            d[i] = 1
        else:
            d[i] += 1
    
        if d[i] > n:
            return i