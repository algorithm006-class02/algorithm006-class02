from collections import Counter
from collections import defaultdict

class Solution:
    def majorityElement(self, nums) -> int:
        return self.majorityElement_v1(nums)
    def majorityElement_v1(self, nums) -> int:
        return list(filter(lambda x: x[1] > len(nums) / 2, Counter(nums).items()))[0][0]
    
    def majorityElement_v2(self, nums) -> int:
        nums.sort()
        return nums[len(nums) // 2]
            
    

if __name__ == "__main__":
    obj = Solution()
    print(obj.majorityElement([1,1,1,1,2,2,1,1]))