学习笔记

###  总结

题目：使用二分查找，寻找一个半有序数组 arr[4, 5, 6, 7, 0, 1, 2] 中间无序的地方。

#### 思路
```json
因题目明确了使用二分查找，时间复杂度要求O(logN)。

既然数组一半有序另一半也有序，且都是递增，出现无序的拐点未知，有可能在第二个位置，可能在倒数第二个位置，也可能出现在中间；可以认为大部分有序直接使用二分查找。
假设low = 0， hight = length -1, mid = (low+hight)/2
(1) 若 arr[low] < arr[mid]， 则说明在[low, mid]之间是有序的，无序拐点在mid右侧，所以向右移动low下标：low = mid
(2) 若 arr[low] > arr[mid]，则说明在[low, mid]之间出现了无序，拐点在其中，所以将hight向左移动：
hight = mid
(3) 若 arr[low] == arr[mid] 且 low < hight; 拐点在mid右侧，移动low下标： low = mid+1

若 low < hight 仍然满足，计算mid = (low+hight)/2，重复上述三种情况，直到low >= hight 退出循环；最后low的位置即为无序开始的拐点。

```

#### 代码

```python
def search(nums: List[int], target: int) -> int:
    if len(nums) <= 1:
        return -1
    low, hight = 0, len(nums) - 1
    while low < hight:
        mid = int((low + hight) / 2)
        if nums[low] < nums[mid]:
            low = mid
        elif nums[low] > nums[mid]:
            hight = mid
        else:
            low = mid + 1
    
    if low >= hight:
        return low

```
