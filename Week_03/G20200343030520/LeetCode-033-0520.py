from typing import List

class Solution:
    """ Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
        (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
        You are given a target value to search. If found in the array return its index, otherwise return -1.
        You may assume no duplicate exists in the array.
        Your algorithm's runtime complexity must be in the order of O(log n).

        Example 1:
            Input: nums = [4,5,6,7,0,1,2], target = 0
            Output: 4

        Template:

            mid, right = 0, len(array)-1

            while left <=right:
                mid = int((left + right) /2)

                if array[mid] == target:
                    break or return result

                elif array[mid] < target:
                    left = mid + 1
                    
                else:
                    right = mid - 1
    """
    def search(self, nums: List[int], target: int) -> int:
        low, high = 0, len(nums) - 1

        while low <= high:
            mid = int((low + high) / 2)

            if nums[mid] == target:
                print(mid)
                return mid

            elif nums[mid] >= nums[low]:
                if target >= nums[low] and target < nums[mid]:
                    high = mid - 1
                    print(high)
                else:
                    low = mid + 1
                    print(low)
            else:
                if target <= nums[high] and target > nums[mid]: 
                    low = mid + 1
                    print(low)
                else:
                    high = mid - 1
                    print(high)
        return -1

if __name__ == "__main__":
    
    s = Solution()
    print(s.search(nums=[2,4,6,8,10,12,14,16,18,20,22], target=16))