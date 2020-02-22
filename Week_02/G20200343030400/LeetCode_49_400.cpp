//40
//https://leetcode-cn.com/problems/group-anagrams

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> res;
        unordered_map<string, int> dict;
        int num = 0;
        string temp;
        for (string str : strs) {
            temp = str;
            sort(temp.begin(), temp.end());
            if (dict.count(temp)) {
                res[dict[temp]].push_back(str);
            } else {
                vector<string> group(1, str);
                res.push_back(group);
                dict[temp] = num++;
            }
        }
        return res;
    }
};
