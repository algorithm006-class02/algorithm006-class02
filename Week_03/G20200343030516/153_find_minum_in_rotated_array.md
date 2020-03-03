### description

153. 寻找旋转排序数组中的最小值
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

请找出其中最小的元素。

你可以假设数组中不存在重复元素。

示例 1:

输入: [3,4,5,1,2]
输出: 1
示例 2:

输入: [4,5,6,7,0,1,2]
输出: 0

```python
class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        lo,hi = 0,len(nums)-1
        if nums[0] < nums[hi]:return nums[0]
        while lo <=hi:
            mid = (lo + hi)>>1
            if nums[mid] > nums[mid+1]:
                return nums[mid+1]
            if nums[mid-1] > nums[mid]:
                return nums[mid]
            if nums[lo] <= nums[mid]: ## 左边有序，min 在右侧
                lo = mid+1
            else: ## 右边有序，min在左侧
                hi = mid-1

```