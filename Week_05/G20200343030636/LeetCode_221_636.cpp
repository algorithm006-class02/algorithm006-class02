/*
 * @lc app=leetcode.cn id=221 lang=cpp
 *
 * [221] 最大正方形
 *
 * https://leetcode-cn.com/problems/maximal-square/description/
 *
 * algorithms
 * Medium (38.81%)
 * Likes:    249
 * Dislikes: 0
 * Total Accepted:    24.3K
 * Total Submissions: 62K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 
 * 示例:
 * 
 * 输入: 
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 
 * 输出: 4
 * 
 */

// @lc code=start
class Solution {
public:
    /*
    解法一：
    定义dp[i][j]为包含位置[i,j]的最大正方形的1的个数：则 
    1.matrix[i][j] = 0 => dp[i][j] = 0
    2.matrix[i][j] = 1 =>  dp[i-1][j]==0 || dp[i-1][j-1]==0 || dp[i][j-1] ==0  => dp[i][j] = 1
                       =>  dp[i-1][j] && dp[i-1][j-1] && dp[i][j-1]  => min(dp[i-1][j],dp[i-1][j-1],dp[i][j-1] ) + 1
                       说明：包含[i,j]点的正方形的需要看这个点周围的几个点，左方[i,j-1]，左上方[i-1,j-1]，上方[i-1,j]，看这几个点代表的正方形
                       是否能扩充到点[i,j]，形成新的正方形。那么必然要这几个取最小的正方形进行扩充，否则变长不够凑不成一个正方形。
    时间复杂度O(m*n) ，空间复杂度O(m*n)
    */
    int maximalSquare(vector<vector<char>>& matrix) {
        if(matrix.size() == 0) return 0;

        vector<vector<int>> dp(matrix.size(),vector<int>(matrix[0].size(),0)) ;

        int maxSqure = 0;

        for(int i = 0 ; i < matrix.size() ; ++i ) {
            dp[i][0] = matrix[i][0] - '0' ;
            maxSqure = max(maxSqure,dp[i][0]);
            cout << dp[i][0] << endl;
        }

        for(int i = 0 ; i < matrix[0].size() ; ++i ) {
            dp[0][i] = matrix[0][i] - '0';
            maxSqure = max(maxSqure,dp[0][i]);
            cout << dp[0][i] << endl;
        }
        
        for(int i = 1 ; i < matrix.size() ; ++ i) {
            for ( int j = 1 ; j < matrix[0].size(); ++ j ) {
                if ( matrix [i][j] == '0' ) {
                    dp[i][j] = 0 ;
                }
                else {
                    if(dp[i-1][j]==0 || dp[i-1][j-1]==0 || dp[i][j-1] ==0 ) {
                        dp[i][j] = 1 ;
                    }
                    else {
                        dp[i][j] = min({dp[i-1][j],dp[i-1][j-1],dp[i][j-1]}) + 1 ;
                    }
                }
                cout << dp[i][j] << endl;
                cout << maxSqure << endl;
                maxSqure = max(maxSqure,dp[i][j]);
            }
        }

        maxSqure = pow(maxSqure,2) ;

        return maxSqure;
        
    }

    /*
    社区高赞解法：优化了空间复杂度，由O(m*n) => O(m) + O(n)
    */
   int maximalSquare(vector<vector<char>>& matrix) {
        if (matrix.empty()) {
            return 0;
        }
        int m = matrix.size(), n = matrix[0].size(), sz = 0;
        vector<int> pre(n, 0), cur(n, 0);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!i || !j || matrix[i][j] == '0') {
                    cur[j] = matrix[i][j] - '0';
                } else {
                    cur[j] = min({pre[j - 1], pre[j], cur[j - 1]}) + 1;
                }
                sz = max(cur[j], sz);
            }
            fill(pre.begin(), pre.end(), 0);
            swap(pre, cur);
        }
        return sz * sz;
    }

    /*
    社区高赞解法：优化了空间复杂度，由O(m) + O(n) => O(n)
    */
    int maximalSquare(vector<vector<char>>& matrix) {
        int nr = matrix.size(); if (nr == 0) return 0;
        int nc = matrix[0].size(); if (nc == 0) return 0;
        
        vector<int> dp(nc+1, 0);
        
        int maxsize = 0;
        
        int last_topleft = 0;  // This is 'pre[i-1]' for the current element
        
        for (int ir = 1; ir <= nr; ++ir) {
            for (int ic = 1; ic <= nc; ++ic) {
                int temp = dp[ic];      // This is 'pre[i-1]' for the next element                
                if (matrix[ir-1][ic-1] == '0') dp[ic] = 0; 
                else {
                    dp[ic] = min({min(dp[ic], dp[ic-1]), last_topleft}) + 1;
                    maxsize = max(maxsize, dp[ic]);
                }
                last_topleft = temp;  // update 'pre[i-1]'
            }
        }
        return maxsize * maxsize;
    }
   
};
// @lc code=end

