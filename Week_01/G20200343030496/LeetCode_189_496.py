class Solution:
    def rotate(self, nums: list, k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n=len(nums)
        k=k%n
        print(1,k)
        def swap(l,r):
            while(l<r):
                nums[l],nums[r]=nums[r],nums[l]#1,4互换，2，3，互换
                l=l+1#1
                r=r-1#
        swap(0,n-k-1)
        swap(n-k,n-1)
        swap(0,n-1)

 #切片，额，过分简单了
        def rotate1(self, nums: list, k: int) -> None:
            n = len(nums)
            k %= n
            nums[:] = nums[n - k:] + nums[:n - k]

        def rotate2(self, nums, k):
            """
            :type nums: List[int]
            :type k: int
            :rtype: None Do not return anything, modify nums in-place instead.
            """
            for _ in range(k):
                previous = nums[-1]  # initiate a first previous
                for i in range(len(nums)):
                    # temp = nums[i]  # hodl nums[i]
                    # nums[i] = previous  # overwrite the current index
                    # previous = temp  # swap the value
                    previous, nums[i] = nums[i], previous


s = Solution()
a = [1,2,3,4,5,6,7]
k = 3
s.rotate(a,k)