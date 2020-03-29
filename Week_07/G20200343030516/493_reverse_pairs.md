493. 翻转对
给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。

你需要返回给定数组中的重要翻转对的数量。

示例 1:

输入: [1,3,2,3,1]
输出: 2
示例 2:

输入: [2,4,3,5,1]
输出: 3

### solution

```python
class Solution:
    def __init__(self):
        self.cnt = 0
    
    def reversePairs(self,nums):
        def msort(lst):
            length = len(lst)
            if length <=1:

            return merge(lst[:int(length/2)],lst[:int(length/2)])

    def merge(left,right):
        l,r = 0,0
        while l < len(left) and r < len(right):
            if left[l] <= 2*right[r]:
                l+=1
            else:
                self.cnt +=len(left) - l
                r-=1
        return sorted( left + right )

```