"""
1、暴力，sorted--->判断sortedStr是否相等；O(logN)
2、hash表：
  1）如果s,t字符数不相同，直接返回False;
  2) 循环s,key为字符，value为次数，如果字符相同则value+=1;
  3) 循环t,如果j在字典的key内，则value-=1;如果value为0，则删除该key;
  4) 判断res字典的长度，如果为0 ，则返回True;否则返回False；
"""

# hash表
def isAnagram(s, t):
    if len(s) != len(t):
        return False
    res = {}
    for i in s:
        if res.get(i) is not None:
            res[i] += 1
        else:
            res[i] = 1
    for j in t:
        if res.get(j) is not None:
            res[j] -= 1
            if res[j] == 0:
                res.pop(j)
    if len(res) == 0:
        return True
    else:
        return False



s = "anagram"
t = "nagaram"

print isAnagram(s, t)