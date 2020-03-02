class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) == 0:
            return -1

        low, hight = 0, len(nums) - 1
        while low < hight:
            mid = int((low + hight) / 2)
            if target == nums[mid]:
                return mid
           
            if ((nums[0] > target) and 
            (nums[0] > nums[mid]) and 
            (target > nums[mid])):
                lo = mid + 1;
            else:
                hi = mid;
        
        if lo == hi and nums[lo] == target:
            return lo
        else:
            return -1
    


