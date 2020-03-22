class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1
        
        low, hight = 0, len(nums) - 1
        
        while low <= hight:
            mid = int(low + (hight - low) / 2)

            if target == nums[mid]:
                return mid
            
            if nums[low] <= nums[mid]:
                # [low, mid] 有序
                if target >= nums[low] and target < nums[mid]:
                    # 向前规约
                    hight = mid - 1
                else:
                    # 向后规约
                    low = mid + 1
            else:
                # [low, mid]无序，有拐点
                if target > nums[mid] and target < nums[low]:
                    # 向后规约
                    low = mid + 1
                else:
                    # 向前规约
                    hight = mid - 1
        if low > hight:
            return -1
    


