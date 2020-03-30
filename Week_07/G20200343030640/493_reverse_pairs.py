"""
493. 翻转对
基于归并算法实现反转对
"""

class Solution:
    def reversePairs(self, nums: List[int]) -> int:
        if not nums: return 0
        return self.mergeSort(nums, 0, len(nums)-1)
    

    def mergeSort(self, nums, s, e):
        if s >= e: return 0
        
        mid = int(s+(e-s)/2)
        count = self.mergeSort(nums, s, mid) + self.mergeSort(nums, mid+1, e)

        i, t = int(s), int(s)
        c, cc_len = 0, int(e-s+1)
        cc = [int(0) for i in range(cc_len)]

        for j in range(mid+1, e+1): #[mid+1, e]
            while i <= mid and (nums[i] <= 2 * nums[j]): i += 1
            while t <= mid and nums[t] < nums[j]:
                cc[c] = nums[t]
                c += 1
                t += 1
            cc[c] = nums[j]
            count += mid+1 - i
            c += 1
        
        while t <= mid:
            cc[c] = nums[t]
            c += 1
            t += 1
        # print(cc)
        for k in range(s, s+cc_len):
            nums[k] = cc[k-s]
        # print(nums)
        return count