/*
 * @lc app=leetcode.cn id=91 lang=cpp
 *
 * [91] 解码方法
 *
 * https://leetcode-cn.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (23.19%)
 * Likes:    304
 * Dislikes: 0
 * Total Accepted:    35.4K
 * Total Submissions: 152.3K
 * Testcase Example:  '"12"'
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 
 * 示例 1:
 * 
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 
 * 
 */

// @lc code=start
class Solution {
public:
	/*
	DP解法：设定d[i]为截止到i位置的子串的解码方法的总数，新增一个数字时，如果数字为0，那么必然要和前一个字符合并解码，则总数为d[i-1],若不为0，要么解释为A-Z，则总数和d[i]一样；要么当10<s[i]s[i+1]<=26构成字符K~Z；则解码总数和d[i-1]一样。
	由此得到递推公式 
	d[i+1]= d[i] + d[i-1] (1<=s[i]+s[i+1]<=26 && s[i+1] != '0') ; 
	      = d[i-2] (int(s[i]+s[i+1]) == '10' or '20')
		  = d[i-1] (int(s[i]+s[i+1]) ~ 0 - 9
		  = 0 other
	4ms 73.39 %
	*/
    int numDecodings(string s) {
		if(s.empty()) return 0;

		if(s[0] == '0' ) return 0;

		if(s.size() == 1 ) {
			return  1;
		}

		vector<int>dp(s.size(),0);


		//初始化dp[0],dp[1]，递推公式需要知道上两个的值
		int code = stoi(s.substr(0,2));
		//cout << code << endl;
		//前两个字符一定要符合解码规则
		if(code == 10 || code == 20) {
			dp[0]=dp[1] = 1;
		}
		else if(code >=1 && code %10 ) {
			dp[0] = 1 ;
			if(code > 10 && code <=26) {
				dp[1] = dp[0] + 1 ;
			}
			else {
				dp[1] = dp[0] ;
			}
		}
		else {
			return 0;
		}

		for(int i = 2 ; i < s.size() ; i++)
		{
			string sub(1,s[i-1]);
			sub.push_back(s[i]);
			int code = stoi(sub);

			if(code == 10 || code == 20) {
				dp[i] = dp[i-2] ;
			}
			else if(code >10 && code <=26) {
				dp[i] = dp[i-1] + dp[i-2] ;
			}
			else if(code > 0 && code % 10 ){
				dp[i] = dp[i-1];
			}
			else {
				return 0;
			}
		}

		return dp[s.size()-1] ;
	}

	/*
	社区高赞解法：DP，但更加简洁
	*/
    int numDecodings(string s) {
		if(s.empty()) return 0;


		vector<int>dp(s.size(),0);

		dp[0] = s[0] != '0' ? 1 : 0;
		
		if(dp[0] == 0 ) return 0 ;

		for(int i = 1 ; i < s.size() ;++i) {
			int cur = s[i] - '0';
			int pre = (s[i-1] -'0')*10 + cur ;
			if(cur != 0) {
				dp[i] += dp[i-1];
			}

			if(pre >= 10 && pre <= 26) {
				dp[i] += i>=2 ? dp[i-2] : 1 ;
			}
		}

		return dp[s.size()-1] ;
	}
};
// @lc code=end
