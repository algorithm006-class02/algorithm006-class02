/*
 * @lc app=leetcode.cn id=66 lang=cpp
 *
 * [66] 加一
 *
 * https://leetcode-cn.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (42.91%)
 * Likes:    425
 * Dislikes: 0
 * Total Accepted:    117.9K
 * Total Submissions: 274.4K
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
    vector<int> plusOne(vector<int>& digits) {

        int tmp=1;
        int org=0;
        for (int i=digits.size()-1;i>=0&&tmp==1;i--) { 
            org=  digits[i];         
            digits[i]=(digits[i]+tmp)%10;
            if (org!=0&&digits[i]==0) {               
                tmp=1;
            }else{
                tmp=0;
            }
        }
        if (tmp==1) {
            vector<int> n(digits.size()+1);
            n[0]=1;
            for( int i=1;i<n.size();i++){
                n[i]=digits[i-1];
            }
            return n; 
        }
        return digits;    
    }
};
// @lc code=end

