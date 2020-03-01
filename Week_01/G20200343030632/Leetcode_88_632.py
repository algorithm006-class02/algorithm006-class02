#
# @lc app=leetcode.cn id=88 lang=python3
#
# [88] 合并两个有序数组
#

# @lc code=start
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        cur = m + n - 1
        i, j = m - 1, n - 1
        while i >= 0 and j >= 0:
            if nums1[i] < nums2[j]:
                nums1[cur] = nums2[j]
                j -= 1
            else:
                nums1[cur] = nums1[i]
                i -= 1
            cur -= 1
        nums1[:j + 1] = nums2[:j+ 1]

# @lc code=end

    