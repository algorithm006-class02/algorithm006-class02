# =====================================
# No.647 回文子串
# 解题思路：从中心往两侧延伸（官方）
# 在长度为 N 的字符串中，可能的回文串中心位置有 2N-1 个
# =====================================

class Solution(object):
    def countSubstrings(self, S):
        N = len(S)
        ans = 0
        for center in range(2*N - 1):
            left = int(center / 2)
            right = int(left + center % 2)
            while left >= 0 and right < N and S[left] == S[right]:
                ans += 1
                left -= 1
                right += 1
        return ans


if __name__ == '__main__':
    solution = Solution()
    test_1 =  'abc'
    test_2 = 'adfafasdfas'
    count1=solution.countSubstrings(test_1)
    count2=solution.countSubstrings(test_2)
    print(count1)
    print(count2)
