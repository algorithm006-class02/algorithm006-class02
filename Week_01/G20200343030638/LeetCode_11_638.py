class Solution:
    def maxArea(self, height: List[int]) -> int:
        max_area = 0
        i, j = 0, len(height) - 1
        while i < j:
            max_area = max(max_area, (j - i) * min(height[i],height[j]))
            if height[i] < height[j]:
                i += 1
            else:
                j -= 1
        return max_area