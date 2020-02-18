class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        """
        # 思路1：暴力破解法，循环遍历，时间复杂度O(k*n)
        for _ in range(k):
            tmp=nums[len(nums)-1]
            i=len(nums)-1
            while i>0:
                nums[i]=nums[i-1] 
                i-=1
            nums[0]=tmp
        """
        """
        # 思路2：直接交换的思想
        size=len(nums)
        k%=size
        count=start=0
        while count < len(nums):
            tmp=nums[start]
            target=start
            while True:
                target=(target+k)%size 
                #tmp=nums[target]
                #nums[target]=pre
                #pre=tmp
                tmp,nums[target]=nums[target],tmp
                count+=1 
                if count>size or target==start:
                    break
            start+=1
        """
        # # 思路3:3次批量反转
        size = len(nums)
        k %= size

        def swap(l, r):
            while l < r:
                nums[l], nums[r] = nums[r], nums[l]
                l += 1
                r -= 1

        swap(0, size - k - 1)
        swap(size - k, size - 1)
        swap(0, size - 1)
