class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: None Do not return anything, modify nums1 in-place instead.
        """

        # 1.直接拼接
        # nums1[:] = sorted(nums1[:m] + nums2)

        # 2. 复制数组，从前往后遍历
        # _nums = nums1[:m]
        # nums1[:] = []
        # i = j = 0
        # while i < m and j < n:
        #     if _nums[i] < nums2[j]:
        #         nums1.append(_nums[i])
        #         i += 1
        #     else:
        #         nums1.append(nums2[j])
        #         j += 1
        
        # if i < m:
        #     nums1[i + j:] = _nums[i:]
        # else:
        #     nums1[i + j:] = nums2[j:]

        # 3.从后往前遍历，节省空间
        p1 = m - 1
        p2 = n - 1
        p = m + n - 1

        while p1 >= 0 and p2 >= 0:
            if nums1[p1] < nums2[p2]:
                nums1[p] = nums2[p2]
                p2 -= 1
            else:
                nums1[p] = nums1[p1]
                p1 -= 1
            p -= 1

        nums1[:p2 + 1] = nums2[:p2 + 1]