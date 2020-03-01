class Solution
{
public:
    vector<vector<string>> groupAnagrams(vector<string> &strs)
    {
        unordered_map<string, vector<string>> h_map;
        for (string &s : strs)
        {
            string sorted_s = s;
            sort(sorted_s.begin(), sorted_s.end());
            h_map[sorted_s].push_back(s);
        }

        vector<vector<string>> result;
        for (auto &p : h_map)
        {
            result.push_back(p.second);
        }

        return result;
    }
};