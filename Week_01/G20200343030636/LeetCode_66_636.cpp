/*
 * @lc app=leetcode.cn id=66 lang=cpp
 *
 * [66] 加一
 *
 * https://leetcode-cn.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (42.88%)
 * Likes:    424
 * Dislikes: 0
 * Total Accepted:    116.9K
 * Total Submissions: 272.3K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    /*
    解法一：从尾部开始增加，判断进位情况，复杂度最坏O(n)；
    0ms 100%
    */
    vector<int> plusOne(vector<int>& digits) {

        if ( digits.size() == 0 ) {
            digits.emplace_back( 1 ) ;
            return digits ;
        }

        int val = digits[ digits.size() - 1 ] + 1 ;
        int more = val / 10 ; 
        digits[ digits.size() - 1 ] =  val % 10 ;
        
        //无进位，直接返回
        if ( more  == 0 ) {
            return digits ;
        }
        //逐个考虑进位情况
        for ( int i  = digits.size()-2 ; i >= 0 ; -- i)
        {
            val = digits [ i ] + more ;
            digits [ i ] = val % 10 ;
            more = val / 10 ;
            if ( more == 0 ) break ; //没有进位了，直接中止；
        }

        if ( more == 1 ) digits.insert ( digits.begin() , more ) ; //数组已经遍历完毕，仍有进位未存储

        return digits ;
    }

    /*
    解法二：解法一逻辑过于复杂，但可复用性高，当前题意只是在最后一位+1，可直接判断最后一位是否是9，不是直接返回即可，不需要单独判断进位，英文网站高赞答案；
    0ms 100%
    */
   vector<int> plusOne(vector<int>& digits) {
        
        //原答案未考虑为空情况；
        if ( digits.size() == 0 ) {
            digits.emplace_back( 1 ) ;
            return digits ;
        }

        for ( int i  = digits.size()-1 ; i >= 0 ; -- i)
        {
            if ( digits [ i ] == 9 )
            {
                digits [ i ] = 0 ; //需要往前进位，继续遍历；
            }    
            else {
                digits [ i ] ++ ; //无需往前进位，直接返回
                return digits ;
            }

        }

        //遍历结束，存在最高位进位未存(否则已返回)
        //digits.insert( digits.begin(),1 ) ;//此写法效率低，因为插入需要移动数据 ,功能等同于下面两句
        digits [ 0 ] = 1 ;
        digits . emplace_back ( 0 );

        return digits ;
    }   
};
// @lc code=end

