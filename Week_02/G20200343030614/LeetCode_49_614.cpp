//引入哈希表
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> res;
        map<string,vector<string>> item;
        string tmp;
        for (int i=0; i<strs.size(); i++) {
            tmp=strs[i];
            sort(tmp.begin(),tmp.end());
            item[tmp].push_back(strs[i]);
        }
        for (auto& it:item) {
            res.push_back(it.second);
        }
        return res;
    }
};