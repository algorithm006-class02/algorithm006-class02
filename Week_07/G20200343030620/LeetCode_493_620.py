class Solution:
    def reversePairs(self, nums: List[int]) -> int:
        #思路1: 使用暴力统计法，时间复杂度为o(n^2)
        """
        #思路2:merge sort 进行统计，时间复杂为o(nlogn)
        def merge(nums,left,mid ,right):
            tmps=[]
            i=left
            j=mid+1
            while i<=mid and j<=right:
                if nums[i]>nums[j]:
                    tmps.append(nums[j])
                    j+=1
                else:
                    tmps.append(nums[i])
                    i+=1
            if i<=mid:
                tmps.extend(nums[i:mid+1])
            if j<=right:
                tmps.extend(nums[j:right+1])
            nums[left:right+1]=tmps[:]


        def merge_sort(nums,left,right):
            if right<=left:
                return 0
            mid=(left+right)>>1
            cnt=merge_sort(nums,left,mid)+merge_sort(nums,mid+1,right)
            #进行合并的时候统计计数 
            for i in range(left,mid+1):
                j=mid+1
                while j<=right and  nums[i]/2>nums[j]: 
                    j+=1
                cnt+=j-(mid+1)
            merge(nums,left,mid,right)
            return cnt 

        return merge_sort(nums,0,len(nums)-1)
        """
        def merge_sort(nums,left,right):
            if right<=left:
                return 0 
            mid=(left+right)>>1 
            cnt=merge_sort(nums,left,mid)+merge_sort(nums,mid+1,right)
            #实现比较计数
            i,t=left,left
            tmps=[]
            j=mid+1
            while j<=right:
                while i<=mid and nums[i]<=2*nums[j]:
                    i+=1
                while t<=mid and nums[t] <= nums[j]:
                    tmps.append(nums[t])
                    t+=1
                tmps.append(nums[j])
                j+=1
                cnt+=mid+1-i
            tmps.extend(nums[t:mid+1])
            nums[left:right+1]=tmps[:]
            return cnt
        return merge_sort(nums,0,len(nums)-1)