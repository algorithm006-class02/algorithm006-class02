/*
 * @lc app=leetcode.cn id=47 lang=cpp
 *
 * [47] 全排列 II
 *
 * https://leetcode-cn.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (56.81%)
 * Likes:    221
 * Dislikes: 0
 * Total Accepted:    38K
 * Total Submissions: 66.8K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,1,2]
 * 输出:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 */

// @lc code=start
class Solution {
    vector<vector<int>> result ;
public:
    
    
    /*
    解法一：参考46全排列的解法，当前位置的数字和后面的每一个进行交换，并记录已经交换过的值，如遇到已经交换过的，则忽略
    12ms 79.31%
    */

    vector<vector<int>> permuteUnique(vector<int>& nums) {
        if ( nums.size() <= 0 ) return result ;

        vector<int> one ;
        //permute(nums ,0, one ) ;
        permuteRecursive(nums, 0, result);

        return result ;
    }

    void permuteRecursive(vector<int> &num, int begin, vector<vector<int> > &result) {
        unordered_set<int> dup ;
		for (int i = begin; i < num.size(); ++i) {
            //让后面的数都交换到begin这个位置上，枚举这个位置所有可能的情况
            //为啥不是从0开始，而是从begin开始对后面的数进行swap呢？举例说明
            //begin = 0,则这个位置包括0在那会交换0～num.size()-1共n次。
            //begin = 1，位置0的数已经确定了，需要排除。那么剩下的就是1～num.size()-1个数能放在begin这个位置上。可用的数字都在后面
            //判定是否已经有相同数字的处理过，去重结果
            if ( dup.find( num[i] ) != dup.end()) continue ; 
            //记录已经交换了的值，后面遇到重复的则过滤
            dup.emplace(num[i]) ;
            swap(num[begin], num[i]); 
            if ( (begin + 1) < num.size() ) {
                permuteRecursive(num, begin + 1, result);
            }
            else {
                result.push_back(num);
            }
            
            // reset，复原。因为num按引用传递，不还原会导致上面的递归最终完毕之后覆盖当前的排列状态。如果num是值传递则不需要还原；
            swap(num[begin], num[i]);    
		}
    } 


    /*
    解法二：类似解法一，但先讲数组排序处理，值相同但元素会排列值一起，遇到重复元素则忽略
    12ms 79.31%
    */

    vector<vector<int>> permuteUnique(vector<int>& nums) {
        if ( nums.size() <= 0 ) return result ;
        //排序
        sort(nums.begin() , nums.end()) ;

        vector<int> one ;
        //permute(nums ,0, one ) ;
        permuteRecursive(nums, 0, result);

        return result ;
    }

    //注意，此处与46题全排列不同，num只能用拷贝而不能用引用，因为引用会打乱排序的结果。顾不可用引用
    void permuteRecursive(vector<int> num, int begin, vector<vector<int> > &result) {

		for (int i = begin; i < num.size(); ++i) {
            //让后面的数都交换到begin这个位置上，枚举这个位置所有可能的情况
            //为啥不是从0开始，而是从begin开始对后面的数进行swap呢？举例说明
            //begin = 0,则这个位置包括0在那会交换0～num.size()-1共n次。
            //begin = 1，位置0的数已经确定了，需要排除。那么剩下的就是1～num.size()-1个数能放在begin这个位置上。可用的数字都在后面
            //判定是否已经有相同数字的处理过，去重结果
            if ( i != begin && num[i] == num[begin] ) continue ;
            
            
            swap(num[begin], num[i]); 
            if ( (begin + 1) < num.size() ) {
                permuteRecursive(num, begin + 1, result);
            }
            else {
                result.push_back(num);
            }            
		}
    } 
    

};
// @lc code=end

