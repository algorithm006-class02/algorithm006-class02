class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i = j = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[j] , nums[i]= nums[i] , nums[j]
                j += 1

#快速排序的思想
#快排： 首先要确定一个待分割的元素作为中间点x,然后把所有小于等于x的点放到x的左边，大于x的值放到其右边

#快排 本质 列表划分为两个子序列 一个是 中间值固定位置一个有序列，前半部分一个相对中间值有序，后半部分一个相对有序，递归的处理子序列。
def quick_sort(arr):
    sort(arr, 0, len(arr)-1 )
def sort(arr, p, r):
    if r <= p:
        return
    q = partition(arr, p, r) #确定最后一个元素的位置
    sort(arr,p, q-1) #递归的排确定位置元素前部分的所有元素
    sort(arr, q+1,r) #递归的排确定位置元素后部分的所有元素
def partition(arr, p, r):  #本质是确定最后一个元素的正确排序后的位置，并将这个元素放到这个位置
    i = 0
    j = r
    pivot = arr[j]

    for k in range(p, r):
        if arr[k] < pivot: #即找到pivot正确的位置:即循环将所有小于给定值的依次放到左半边最后确定pivot的位置即为正确的位置 ，
            arr[i],arr[k] = arr[k], arr[i]
            i += 1
    #将pivot 放入正确的位置
    arr[i],arr[j] = arr[j], arr[i]


class Solution:
    def moveZeroes(self, nums: list[int]) -> None:
        i = j = 0 
        for i in range(len(nums)):
            if nums[i] != 0 :
                nums[j], nums[i] = nums[i], nums[j]
                j += 1

#优化上法执行效率版本
class Solution:
    def moveZeroes(self, nums: list[int]) -> None:
        j = 0 #0的位置，i是顺序遍历
        for i in range(len(nums)):
            if nums[i] != 0 and i == j:
                j += 1 #互换之后0的位置变了, 不是0 则 加1
            elif nums[i] != 0 and i != j 
                nums[i],nums[j] = nums[i],nums[j]
                j += 1
            
            
                