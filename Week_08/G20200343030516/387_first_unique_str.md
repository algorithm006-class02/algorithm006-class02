387. 字符串中的第一个唯一字符
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:

s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.
 
 ### solution
 ```python
 class Solution:
    def firstUniqChar(self, s: str) -> int:
        dict1 = collections.Counter(s)
        for i in range(len(s)):
            if dict1[s[i]] == 1:
                return i
        return -1

 ```

```java
class Solution{
    public int firstUniqune(String s ){
        HashMap<Character, Interger> count = new HashMap<Charater,Integer>();
        int n = s.length();
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            count.put(c,count.getOrdefault(c,0) +1)
        }

        for(int i = 0; i<n; i++){
            if(count.get(s.charAt(i))==1)
                return i;
        }
        return -1
    }
}

```