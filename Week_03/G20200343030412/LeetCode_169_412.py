class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        # 暴力法
        # nums = sorted(nums)
        # x = 0 # 记录当前数
        # c = 0 # 记录当前数个数
        # max_x = 0 # 记录众数
        # max_c = 0 # 记录最大数目
        # if len(nums) == 1: return nums[0]
        # for n in nums:
        #     if x == n :
        #         c += 1
        #         if max_c<=c:
        #             max_c = c
        #             max_x = n
        #     else:
        #         x = n
        #         c = 1
            
        # return max_x

        # 分治
        def majority_element_rec(lo, hi):
            # base case; the only element in an array of size 1 is the majority
            # element.
            if lo == hi:
                return nums[lo]

            # recurse on left and right halves of this slice.
            mid = (hi-lo)//2 + lo
            left = majority_element_rec(lo, mid)
            right = majority_element_rec(mid+1, hi)

            # if the two halves agree on the majority element, return it.
            if left == right:
                return left

            # otherwise, count each element and return the "winner".
            left_count = sum(1 for i in range(lo, hi+1) if nums[i] == left)
            right_count = sum(1 for i in range(lo, hi+1) if nums[i] == right)

            return left if left_count > right_count else right

        return majority_element_rec(0, len(nums)-1)
