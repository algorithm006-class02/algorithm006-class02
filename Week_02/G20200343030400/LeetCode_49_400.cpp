//49
//https://leetcode-cn.com/problems/group-anagrams

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> res;
        unordered_map<string, vector<string>> dict;
        for (string s : strs) {
            string temp = s;
            sort(temp.begin(), temp.end());
            dict[temp].push_back(s);
        }
        for (auto entry : dict) {
            res.push_back(entry.second);
        }
        return res;
    }
};
