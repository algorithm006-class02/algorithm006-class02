class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]: return False

        m, n = len(matrix), len((matrix[0]))

        # 从左下角开始遍历，判断target在哪一行
        while matrix[m - 1][0] > target and m > 1:
            m -= 1

        # 二分查找
        l, r = 0, n - 1
        while l <= r:
            mid = (l + r) // 2
            tmp = matrix[m - 1][mid]
            if tmp == target:
                return True
            elif tmp > target:
                r = mid - 1
            else:
                l = mid + 1
        return False