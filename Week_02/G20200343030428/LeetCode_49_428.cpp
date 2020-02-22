/*
 * @lc app=leetcode.cn id=49 lang=cpp
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> result;
        int sub = 0;    //result，每个vector的下标
        string tmp;     //临时存储 string 数据
        unordered_map<string,int> work; //string 记录排序后的word, int记录sub
        for (auto str: strs) {
            tmp = str;
            // 排序很重要，保证键一致
            sort(tmp.begin(), tmp.end());
            // 如果键存在就插入已经存在的vector
            // 如果不存在就插入新的vector
            if (work.count(tmp)) {
                result[work[tmp]].push_back(str);
            }
            else {
                vector<string> tmp_v(1, str);
                result.push_back(tmp_v);
                work[tmp] = sub++;
            }
        }
        return result;
    }
};
// @lc code=end

