# =====================================
# No.189 旋转数组
# 解题思路：三次替换法
# 待解决：k = k%n 没有明白原理
# =====================================
class Solution(object):
    def rotate(self, nums, k):
        n=len(nums)		
        if(k > n):
            k = k%n
        def swap(i,j):
            while(i<j):
                nums[i],nums[j]=nums[j],nums[i]
                i=i+1
                j=j-1
        swap(0,n-k-1)
        swap(n-k,n-1)
        swap(0,n-1)