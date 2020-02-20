class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        """
        思路1：简单的插入排序算法 
        """
        # 思路2:在简单插入排的基础上减少移动的次数，移动指针从后往前移动，实现时间复杂度为O(n+m)
        i = m - 1
        j = n - 1
        p = m + n - 1
        while i >= 0 and j >= 0:
            if nums1[i] >= nums2[j]:
                # 直接将元素一次性放到正确的位置
                nums1[p] = nums1[i]
                i -= 1
            else:
                nums1[p] = nums2[j]
                j -= 1
            p -= 1
        # 数组拷贝的巧妙点1
        nums1[:j + 1] = nums2[:j + 1]
