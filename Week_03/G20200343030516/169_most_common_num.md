## description

169. 多数元素
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2

## solution
方法1 考虑回溯（会超时）
```python

def majorityElement(self, nums):
    def majority_element_rec(lo, hi):
        # base case; the only element in an array of size 1 is the majority
        # element.
        if lo == hi:
            return nums[lo]

        # recurse on left and right halves of this slice.
        mid = (hi-lo)//2 + lo
        left = majority_element_rec(lo, mid)
        right = majority_element_rec(mid+1, hi)

        # if the two halves agree on the majority element, return it.
        if left == right:
            return left

        # otherwise, count each element and return the "winner".
        left_count = sum(1 for i in range(lo, hi+1) if nums[i] == left)
        right_count = sum(1 for i in range(lo, hi+1) if nums[i] == right)

        return left if left_count > right_count else right

    return majority_element_rec(0, len(nums) -1)


```


更推荐的解法：
```python
def mostCommon(nums):
    count = 0
    for i in nums:
        if count == 0 :
            ans = i
        count += (1 if ans == i else -1)
    return ans
```