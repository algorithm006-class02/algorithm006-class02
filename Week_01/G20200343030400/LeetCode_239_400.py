class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        size = len(nums)
        if size * k == 0:
            return []
        if k == 1:
            return nums
        if k > size:
            k = size

        dq, ans = [], []
        for i in range(size):
            while dq and nums[i] >= nums[dq[-1]]:
                dq.pop()
            dq.append(i)
            if (dq[0] + k) == i:
                dq.pop(0)
            if i >= k - 1:
                ans.append(nums[dq[0]])
        return ans;
