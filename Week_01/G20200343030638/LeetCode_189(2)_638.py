class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k = k % n
        while k:
            end = nums.pop()
            nums.insert(0, end)
            k -= 1
