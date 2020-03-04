Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

### solution
借用一个dict：
遍历s,并对于每个iter 对应dict的 key +1
遍历t,并对于每个iter 对应dict的 key -1
满足条件，最后所有值都应该 为0


时间复杂度O（n）
空间复杂度O（n）
```python
def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) != len(t):
            return False
        dicts = collections.defaultdict(int)
        for i in range(len(s)):
            dicts[s[i]] = dicts[s[i]] + 1
            dicts[t[i]] = dicts[t[i]] - 1
        for val in dicts.values():
            if val != 0:
                return False
        return True
```

上一个解法比较慢：
参考别人：
```python
def isAnagram(self, s: str, t: str) -> bool:
    # 定义默认布尔值参与后续运算
    result = True
    # 利用 Python 数据结构 set 去重去序
    set_tmp = set(s)
    # 先判断组成字符串的各个字符元素是否一致
    if set_tmp == set(t):
        for i in set_tmp:
            # 利用逻辑运算符判断各个字符元素的数量一致，均为 True 才输出 True
            result = result and (s.count(i) == t.count(i))
    else:
        result = False
    return (result)

```

相同solution :
java
```java
public boolean isAnagram(String s,String t) {
    if(s.length()!=t.length()){
        return false;
    }
    int[] counter = new int[26];
    for(int i = 0; i<s.length();i++){
        counter[s.charAt(i) -'a']++;
        counter[t.charAt(i) -'a']--;
    }
    for(int cont: counter){
        if(cont!=0) {
            return false;
        }
    }
    return true;
}

```

javascript
```javascript
var isAnagram = function(s,t){
    if(s.length!=t.length){
        return false
    }
    const wordMap ={}
    for(let i= 0;i<s.length;i++){
        wordMap[s[i]]?
        (wordMap[s[i]]++)
        :(wordMap[s[i]]=1)
    }
    for(let i = 0;i<t.length;i++){
        if(wordMap[t[i]]&&wordMap[t[i]]>0){
            wordMap[t[i]]--
        }else{
            return false
        }
    }
    return true
}

```
