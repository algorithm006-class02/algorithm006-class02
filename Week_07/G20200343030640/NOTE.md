学习笔记

## 初级排序算法
### 选择排序
```python
# -*-coding:utf-8 -*-
import random

lst = [1,5,6,9,10,12,20,22,24,25,30,50]
random.shuffle(lst)
print(lst)

def selectionSort(arr=None):
    if not arr:
        return
    length = len(arr)
    for i in range(length-1):
        min = i
        for j in range(i, length):
            if arr[min] > arr[j]:
                min = j # 保存最小值下标
        arr[i], arr[min] = arr[min], arr[i]
        
# 选择排序（升序排序）
selectionSort(arr=lst)
print(lst)
```

### 插入排序
```python
# -*-coding:utf-8 -*-
import random

lst = [1,5,6,9,10,12,20,22,24,25,30,50]
random.shuffle(lst)
print(lst)

def insertionSort(arr=None):
    if not arr:
        return
    length = len(arr)
    # 第一个位置认为有序，从1开始
    for i in range(1, length):
        curr = arr[i]
        sortedIdx = i - 1
        while sortedIdx >= 0 and arr[sortedIdx] > curr:
            arr[sortedIdx+1] = arr[sortedIdx]
            sortedIdx -= 1

        arr[sortedIdx+1] = curr

# 插入排序
insertionSort(arr=lst)
print(lst)
```

### 冒泡排序
```python
import random

lst = [1,5,6,9,10,12,20,22,24,25,30,50]
random.shuffle(lst)
print(lst)

def bubbleSort(arr=None):
    if not arr:
        return
    length = len(arr)
    for i in range(length-1):
        for j in range(length-1-i):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]

bubbleSort(arr=lst)
print(lst)
```