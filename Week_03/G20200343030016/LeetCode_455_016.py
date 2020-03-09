# =====================================
# No.455 分发饼干
# 解题思路：贪心算法
# 现将小孩的胃口和饼干大小进行从小到大的排序，从胃口最小的小孩开始分饼干；
# 如果小孩的胃口小于或者等于饼干大小，就分给他，继续下一个小孩。否则，小孩不变，继续下一个饼干；
# =====================================


class Solution(object):
    def findContentChildren(self, g, s):
        # 记录分配到饼干的小孩数
        count = 0
        i = 0
        j = 0
        # 从小到大排序
        g = sorted(g, reverse=False)
        s = sorted(s, reverse=False)

        while i < len(g) and j < len(s):
            if(g[i] <= s[j]):
                count += 1
                i += 1
            j += 1
        return count


if __name__ == '__main__':
    solution = Solution()
    g = [10, 9, 8, 7]
    s = [5, 6, 7, 8]
    print(solution.findContentChildren(g, s))
