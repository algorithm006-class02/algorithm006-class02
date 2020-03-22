### description
45. 跳跃游戏 II
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

示例:

输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。


### solution
贪心算法
+ 每次跳跃的位置是上一次能跳跃到达最远的位置
+ 在当前区间里面找到下次能跳跃到达的最远位置
+ 搜寻空间是[0,len(nums)-1)
```python
class Solution:
    def jump(self, nums: List[int]) -> int:
        step = 0
        cur_maxPosition = 0
        frontier = 0
        for i in range(len(nums)-1):
            cur_maxPosition = max(cur_maxPosition,nums[i] +i)
            if i== frontier:
                step +=1
                frontier = cur_maxPosition
        return step
```