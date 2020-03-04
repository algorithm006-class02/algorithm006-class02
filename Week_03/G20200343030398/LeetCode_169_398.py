# 169.多数元素

# 解法一：hash记录每个数字出现的次数
# 解法二：排序后找n/2下标元素
# 解法三：分治(不直观)
# 解法四：Boyer-Moore 投票算法

import collections


# 解法一 O(N)
class Solution:
    def majorityElement(self, nums) -> int:
        mode = len(nums) // 2
        help = collections.defaultdict()
        for value in nums:
            count = help.get(value, 0) + 1
            if count > mode:
                return value
            help[value] = count


# 解法四 O(N)
class Solution2:
    def majorityElement(self, nums):
        count = 0
        candidate = None

        for num in nums:
            if count == 0:
                candidate = num
            count += 1 if num == candidate else -1

        return candidate


solution = Solution()
case = [3, 2, 3]
print(solution.majorityElement(case))
case = [2, 2, 1, 1, 1, 2, 2]
print(solution.majorityElement(case))
