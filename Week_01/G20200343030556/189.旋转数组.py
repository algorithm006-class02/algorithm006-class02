class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

        # # 1、暴力法，模拟过程
        # k %= len(nums)
        # for i in range(k):
        #     tmp = nums[-1]
        #     for j in range(len(nums) - 1, 0, -1):
        #         nums[j] = nums[j - 1]
        #     nums[0] = tmp
        
        # # 2. 拼接
        # k %= len(nums)
        # nums[:] = nums[-k:] + nums[:-k]

        # # 3. 三重翻转
        # k %= len(nums)
        # nums[:] = nums[::-1]
        # nums[:k] = nums[:k][::-1]
        # nums[k:] = nums[k:][::-1]

        # 4. 额外数组（非原地）
        size = len(nums)
        k %= size
        _nums = [num for num in nums]
        for i in range(size):
            nums[(i + k) % size] = _nums[i]