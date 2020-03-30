学习笔记
本周主要是针对布隆过滤去，LRU缓存以及排序进行了学习。其中我认为印象最深刻的就是排序，因为在之前的面试中，经常遇到排序的问题，而确实nlogn得排序出现的是最多的，也就是堆排序，快速排序以及归并排序。
冒泡排序：
class Solution(object):
    def __init__(self,l):
        self.l = l

    def mp_sort(self):
        for i in range(len(self.l)):
            for j in range(len(self.l)-i-1):
                if self.l[j] > self.l[j+1]:
                    self.l[j+1], self.l[j]= self.l[j], self.l[j+1]
                else:
                    pass
        print(self.l)

P = Solution([2,7,3,11,25,9,14,3])
P.mp_sort()

#插入排序
def insertionSort(arr): 
  
    for i in range(1, len(arr)): 
  
        key = arr[i] 
  
        j = i-1
        while j >=0 and key < arr[j] : 
                arr[j+1] = arr[j] 
                j -= 1
        arr[j+1] = key 
  
  
arr = [12, 11, 13, 5, 6] 
insertionSort(arr) 
print ("排序后的数组:") 
for i in range(len(arr)): 
    print ("%d" %arr[i])

#希尔排序
def shellSort(nums):
    step = len(nums)/2
    while step > 0:
        for i in range(step, len(nums)):
            while i >= step and nums[i-step] > nums[i]:
                nums[i], nums[i-step] = nums[i-step], nums[i]
                i -= step
        step = step/2
    return nums