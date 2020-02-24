/*
 * @lc app=leetcode.cn id=49 lang=cpp
 *
 * [49] 字母异位词分组
 *
 * https://leetcode-cn.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (60.61%)
 * Likes:    266
 * Dislikes: 0
 * Total Accepted:    50.1K
 * Total Submissions: 82.5K
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
    /*
    解法一：排序每个字符串，用hash存储，对于排序后一样的字符串，放入同一个列表。和社区高赞解法一样，但可以进一步优化的是
    字符串的排序，题目限定了都是小写字母，可针对这特性进行排序
    44ms 83.5%
    */
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> result ;
        unordered_map<string,vector<string> > same ; 
        //排序
        for ( auto & ori : strs  ) {
            string str = ori ;
            //sort( str.begin() , str.end() ) ;
            sortLowercase(str) ;
            if ( same.find(str) != same.end() ) {
                same[str].emplace_back(ori) ;
            }
            else {
                vector<string> one({ori}) ;
                same.emplace(str,one) ;
            }
        }

        for ( auto & one : same ) {
            result.emplace_back(one.second) ;
        }

        return result;
        
    }


    string sortLowercase(string s) {
        int charExist[26] = {0};
        for (int i = 0; i < s.size(); i++) {
            charExist[s[i] - 'a']++;
        }
        string res;
        int j = 0;
        while (j < 26) {
            if (charExist[j] == 0) {
                j++;
            }
            else {
                res.push_back(j + 'a');
                charExist[j]--;
            }
        }
        return res;
    }
};
// @lc code=end

