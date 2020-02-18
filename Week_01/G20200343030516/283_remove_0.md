题目描述：
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/move-zeroes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

题解：

采用双指针，快慢。
其中快指针从数组开始，每次向后移动一个；慢指针从数组开始，每次交换数据移动。


遇到非零元素，往最前面移动，移动完毕后，前面非0元素数目加一，同时移动后的非0 元素位置制0

```python
 def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        lastNonZeroFoundAt  = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[i], nums[lastNonZeroFoundAt] = nums[lastNonZeroFoundAt], nums[i]
                lastNonZeroFoundAt  += 1
```


老师写法
```python
 def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        lastNonZeroFoundAt  = 0
        for i in range(len(nums)):
            if nums[i] != 0:
               nums[lastNonZeroFoundAt] = nums[i]
               if i != lastNonZeroFoundAt:
                    nums[lastNonZeroFoundAt] = 0
                lastNonZeroFoundAt += 1

```