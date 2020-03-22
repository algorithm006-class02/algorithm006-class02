# -*- coding: utf-8 -*-
"""
120. 三角形最小路径和
[
    [2]
    [3,4]
    [6,5,7]
    [4,1,8,3]
]
bottom-up
"""

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if not triangle:
            return
        for row in range(len(triangle)-2, -1, -1):
            for col in range(len(triangle[row])):
                triangle[row][col] += min(triangle[row+1][col], triangle[row+1][col+1])
        print(triangle)
        return triangle[0][0]
