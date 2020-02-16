class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k = k % n
        while k:
            pre = nums[-1]
            for j in range(n):
                tmp = nums[j]
                nums[j] = pre
                pre = tmp
            k -= 1