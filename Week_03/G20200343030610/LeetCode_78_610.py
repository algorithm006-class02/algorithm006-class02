#v1 未理解
class Solution:
    def subsets(self, nums: List[int])->List[List[int]]:
        output = [[]]
        for num in nums:
            output += [cur + [num] for curr in output]
        return output    
#v2 

