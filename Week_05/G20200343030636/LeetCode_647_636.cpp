/*
 * @lc app=leetcode.cn id=647 lang=cpp
 *
 * [647] 回文子串
 *
 * https://leetcode-cn.com/problems/palindromic-substrings/description/
 *
 * algorithms
 * Medium (60.54%)
 * Likes:    194
 * Dislikes: 0
 * Total Accepted:    18.8K
 * Total Submissions: 30.8K
 * Testcase Example:  '"abc"'
 *
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * 
 * 示例 1:
 * 
 * 
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * 
 * 
 * 注意:
 * 
 * 
 * 输入的字符串长度不会超过1000。
 * 
 * 
 */

// @lc code=start
class Solution {
public:

    /*
    定义dp[i]为以位置i为中心的回文子串的数量,则d[i]=长度=1+长度=2+长度=3.....（以i为中心的回文串)
    4ms 97.82%
    */
    int countSubstrings(string s) {
        int sum = 0 ;
        for(int i = 0 ; i < s.size() ; ++i)
        {
            //cout << i << endl;
            sum += get(s,i);
        }

        return sum ;
    }

    int get(string &s,int pos) {
        //以pos为中心的奇数长度的回文串
        int sum = 1 ;//包含自己
        for(int i = pos - 1, j = pos + 1 ;i >=0 && j < s.size(); --i,++j) {
            if(s[i] != s[j]) break;
            
            sum++;
        }

        //以pos为中心的偶数长度的回文串
        if(pos<(s.size()-1) && s[pos] == s[pos+1]) {
            //pos和pos+1已经是一个新的回文，计数加1
            sum++;
            for(int i = pos - 1, j = pos + 2 ;i >=0 && j < s.size(); --i,++j) {
                if(s[i] != s[j]) break;
                
                sum++;
            }           
        }

        return sum ;

    }




    /*
    解法二：动态规划解法:定义 dp[i][j]为从位置i到j的子串是否为回文
dp[i][j] is true if s[i] == s[j] and dp[i+1][j-1] is true (j - i >= 2)
dp[i][j] is true if s[i] == s[j] (j - i == 1)
dp[i][j] is true (j - i == 0)
i is decreasing, dist = j - i is increasing

    */
    int countSubstrings(string s) {
        vector<vector<int>> dp(s.size(), vector<int>(s.size(), true));
        int count = s.size(); // Diagonal must be palindromic
        //从尾部开始，是因为如果从头计算dp，dp[0][5]需要先知道dp[1][4],而位置[1][4]的子串还并没有进入计算过程
        for (int start = s.size() - 1; start >= 0; start--) {
            for (int dist = 1; start + dist < s.size(); dist++) {
                int end = start + dist;
                
                if (s[start] == s[end] && (dist == 1 || dp[start + 1][end - 1])) {
                    // dp[start][end] = true; // Don't need this statement because the element is true initially
                    count++; // Increment count for every palindromic start-end pair that is non diagonal because dist starts from 1
                } else {
                    dp[start][end] = false;
                }
            }
        }
        
        return count;
    }



    int countSubstrings(string s) {
        int count = 0 , n = s.size();
        vector<vector<bool> dp(n,vector<bool>(n,false)) ;

        for(int d = 0 ; d < n ;d++) {
            for(int i = 0 ; i + d < n ; i++) {
                int j = i + d;
                if(s[i] == s[j]) {
                    dp[i][j] = (i + 1 >= j - 1) ? true : dp[i + 1][ j - 1 ] ;
                    if(dp[i][j]) count ++ ;
                }
            }
        }

        return count ;
    }

};
// @lc code=end

