### 第一周 
#### 第三课

##### 实战题目: 移动零 (Python)  leetcode 283

```python
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        index = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                index += 1
            else:
                nums[i - index] = nums[i]

        index0 = len(nums) - index
        while index0 <= len(nums) -1:
            nums[index0] = 0
            index0 +=1

```

> 解题思路

数字0后移，其实就是非0前移;<br >
index变量 计数 value 为 0 的个数;<br>
nums长度减去 index计数 就是需要修改的索引值.

```python
index = 0
for i in range(len(nums)):
    if nums[i] != 0:
        if i > index:
            nums[index] = nums[i]
            nums[i] = 0
        index += 1
```



#### 实战题目: 盛水最多的容器、爬楼梯 (Python)  leetcode 11

```python
class Solution:
    def maxArea(self, height: List[int]) -> int:
        left = 0
        right = len(height) - 1
        area = 0 
        while left < right:
            coun = min(height[left], height[right]) * (right - left)
            area = max(area, coun)
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1

        return area
```

> 解题思路

1. 两条垂直线的距离越远越好，两条垂直线的最短长度也要越长越好。
2. 设置两个指针 left 和 right (双指针) 最左 和 最右
3. 木桶原理 求最小面积, 最右减去最左边,获取它们之间的长度

#### 实战题目: 两数之和 (Python)  leetcode 01

```python
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)):
            temp = nums[:i]
            if target - nums[i] in temp:
                res = temp.index(target - nums[i])
                break
        return [res,i]

```

> 解题思路

1.  循环当前数组，用总和 减去 遍历的第一个数字，得出的结果是否包含在剩余的数组中。