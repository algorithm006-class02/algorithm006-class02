## description
53. 最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

### solution

dp[i] = max(nums[i]+ dp[i-1],dp[i-1])

```python
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        cur_sum =0
        res = nums[0]
        for i in nums:
            cur_sum += i
            res = max(res,cur_sum)
            if cur_sum < 0:
                cur_sum = 0
        return res
```