class Solution:
INT_MAX = 2**31 - 1
INT_MIN = -2**31

def myAtoi(self, s: str) -> int:
    s = s.strip()
    if not s:
        return 0
    sign = 1
    if s[0] == "+":
        s = s[1:]
    elif s[0] == "-":
        s = s[1:]
        sign = -1
    i, ret, count = 0, 0, len(s)
    while count > i and "0" <= s[i] <= "9":
        if sign * ret > self.INT_MAX // 10 or sign * ret < self.INT_MIN // 10:
            return self.INT_MAX if sign == 1 else self.INT_MIN
        if ret == self.INT_MAX // 10:
            if sign == 1 and (self.INT_MAX - ret * 10) <= int(s[i]):
                return self.INT_MAX
            if sign == -1 and (self.INT_MIN + ret * 10 + int(s[i])) >= 0:
                return self.INT_MIN
        ret = ret * 10 + int(s[i])
        i += 1
    return ret * sign
