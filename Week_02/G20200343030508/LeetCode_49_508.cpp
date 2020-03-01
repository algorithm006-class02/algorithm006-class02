/*
 * @lc app=leetcode.cn id=49 lang=cpp
 *
 * [49] 字母异位词分组
 *
 * https://leetcode-cn.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (60.65%)
 * Likes:    271
 * Dislikes: 0
 * Total Accepted:    51.5K
 * Total Submissions: 84.6K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 示例:
 * 
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * 说明：
 * 
 * 
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> res;
        int sub=0;//分组总数
        string tmp;
        unordered_map<string, int> w;
        for(auto str:strs) {
            tmp=str;
            sort(tmp.begin(),tmp.end());
            if(w.count(tmp)) {
                res[w[tmp]].push_back(str);
            }else {
                vector<string> v(1,str);
                res.push_back(v);
                w[tmp]=sub++;
            }
        }
        return res;

    }
};
// @lc code=end

