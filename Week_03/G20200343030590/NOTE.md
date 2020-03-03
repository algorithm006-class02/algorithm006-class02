学习笔记

# 使用二分查找，寻找一个半有序数组[4,5,6,7,0,1,2]中间无序的地方

- 思路：

  - 首先理解题目的含义，半有序数组可以理解为最大和最小的元素不在数组开头或末尾。引申下即可以在某个分界处将数组一分为二"劈开"。
    这自然而然想到了二分查找
  - 但是怎么找到无序的那个分界点，一个是采用暴力手段，从第一个元素一个一个往后比较，直到找到的下一个元素比自己小停下来。这里还要注意
    corner cases。加入最后的值大于第一个值，那么这个数组是升序的，不存在无序的地方。
  - 二分查找则是从中间开始（无论中间是什么值），将数组分成两部分，如果中间的值a[mid] > a[left]则证明无序的地方在mid的右边。相反，如果
    a[mid] < a[left]则无序的地方在mid的左边。依次不断找，时间复杂度是O(log(n))。不依赖额外空间，空间复杂度为O(1)。
    
- 代码：

  ```
  def find_unsort_of_array(array: int[]):
    left, right = 0, array.length - 1
    
    if array[left] < array[right]:
        return -1
    mid = (right - left) / 2
    while left < right:
        if array[mid] > array[left]:
            left = mid + 1
        elif array[mid] == array[left]:
            return array[mid]
        else:
            right = mid - 1
    return -1        
  ```