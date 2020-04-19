# =====================================
# No.242  有效的字母异位词
# 解题思路：先判断两个字符串的长度，如果长度不同直接返回false。然后，将字符串中的字母排序，如果相同则是异位词
# =====================================


class Solution(object):
    def isAnagram(self, s, t):
        if(len(s) != len(t)):
            return False
        if sorted(s) == sorted(t):
            return True
        else:
            return False


if __name__ == '__main__':
    sol = Solution()
    s1='anagram'
    t1='nagaram'
    s2='rat'
    t2='car'    
    print(sol.isAnagram(s1,t1))
    print(sol.isAnagram(s2,t2))