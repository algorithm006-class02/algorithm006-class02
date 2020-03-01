class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> va;
        unordered_map<string,vector<string>> ump;
        for (auto i : strs){
            string temp = i;
            sort(temp.begin(),temp.end());
            ump[temp].push_back(i);
        }
        for (auto i : ump){
            va.push_back(i.second);
        }
        return va;
    }
};