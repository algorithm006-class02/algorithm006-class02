## 49 49. Group Anagrams
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

## solution
+ 对每个item,进行sort()
+ 对sorted item 在hash table 里面查询，并且返回该值

```python
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        ans = collections.defaultdict(list)
        for s in strs:
            ans[tuple(sorted(s))].append(s)
        return list(ans.values())
```
参考代码：
C++ 代码通过额外增加下标储存每个item需要插入的位置，加速。
```c++
class Solution{
    public:
    vector<vector<string>> groupAnagrams(vector<string>& strs){
        vector<vector> res;
        int sub = 0;
        string tmp;
        unordered_map<string,int> word_dict;
        for(auto str:strs){
            tmp = str;
            sort(tmp.begin(),tmp.end());
            if(word_dict.count(tmp)){
                res[word_dict[tmp]].push_back(str);
            }
            else{
                vector<string> vec(1,str);
                res.push_back(vec);
                word_dic[tmp] = sub++;
            }
        }
    }
}

```
