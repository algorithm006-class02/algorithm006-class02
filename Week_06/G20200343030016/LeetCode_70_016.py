# =====================================
# No.70 爬楼梯问题
# 解题思路：f(i)=f(i−1)+f(i−2)
# =====================================


class Solution(object):
    def climbStairs(self, n):
        f = [1, 2]
        for i in range(2, n):
            f.append(f[i-1] + f[i-2])
        return f[n-1]


if __name__ == '__main__':
    solution = Solution()
    step1 = solution.climbStairs(55)
    step2 = solution.climbStairs(56)
    step3 = solution.climbStairs(57)
    if(step3 == step1+step2):
        print('true')
    else:
        print('false')
