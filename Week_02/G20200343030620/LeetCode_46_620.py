class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []

        def backtrack(res, cur=0, tmps=[]):
            if len(tmps) == len(nums):
                # 如果该出写为res.append(tmps),则返回值为[[]]的形式
                res.append(tmps[:])
                return
            for val in nums:
                if val not in tmps:
                    tmps.append(val)
                    backtrack(res, val, tmps)
                    tmps.pop()

        backtrack(res)
        return res
