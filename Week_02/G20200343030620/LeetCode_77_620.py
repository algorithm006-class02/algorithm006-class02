class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []
        if k > n:
            return []

        def helper(start=1, nums=[]):
            if len(nums) == k:
                res.append(nums[:])
                return
            for i in range(start, n + 1):
                nums.append(i)
                helper(i + 1, nums)
                # 进行回溯，执行算法的关键
                nums.pop()

        helper()
        return res
