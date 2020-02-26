/*
 * @lc app=leetcode.cn id=74 lang=cpp
 *
 * [74] 搜索二维矩阵
 *
 * https://leetcode-cn.com/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (37.45%)
 * Likes:    134
 * Dislikes: 0
 * Total Accepted:    32.3K
 * Total Submissions: 86.3K
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,50]]\n3'
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 
 * 
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * 
 */

// @lc code=start
class Solution {
public:
    /*
    8ms,88.18%
    */
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        for( auto & one : matrix) {
            if ( one.size() > 0  && target  <= one.back()) {
                if ( binarySearch( one , target )) return true ;
            }
            
        }
        return false ;
    }

    bool binarySearch ( vector<int> & one , int target) {
        int left = 0 , right = one.size() - 1 ;

        while( left <= right ) {
            int mid = left + right >> 1 ;

            if( target == one[mid]) {
                return true ;
            }
            else if( target < one[mid]) {
                right = mid - 1 ;
            }
            else {
                left = mid + 1;
            }
        }

        return false ;
    }



};
// @lc code=end

