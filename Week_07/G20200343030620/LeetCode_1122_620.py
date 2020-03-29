class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        #思路1: 遍历查找，进行交换，时间复杂度o(m*n),但没有在arr2 中的值需要按照升序排列
        #思路2: 使用计数排序算法来实现
        arr=[0 for _ in range(1001)]
        res=[]
        for val in arr1:
            arr[val]+=1
        for val in arr2:
            while arr[val]>0:
                res.append(val)
                arr[val]-=1 
        for i in range(1001):
            while arr[i]>0:
                res.append(i)
                arr[i]-=1
        return res