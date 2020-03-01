/*
 * @lc app=leetcode.cn id=46 lang=cpp
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (73.90%)
 * Likes:    529
 * Dislikes: 0
 * Total Accepted:    77.2K
 * Total Submissions: 104.3K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 */

// @lc code=start
class Solution {
private :
    vector<vector<int>> result ;
public:
    /*
    解法一：插空思路：
    已有1个数字，再来一个数字可以插入前面或者后面，共2个位置
    已有2个数字，再来一个数字可以插入前面，中间，后面，共3个位置
    ...依此类推，n个数字有n+1个位置可以插空。也即每次都把数字i都所有可能情况枚举，
    按此思路可获得完整全排列
    整个过程需要记录哪些数字已经使用过了，哪些还没有；
    8ms 80.81%
    */
        vector<vector<int>> permute(vector<int>& nums) {
        if ( nums.size() <= 0 ) return result ;
        
        vector<int> one ;
        //选择下标为0第数字进行插入
        permute(nums ,0, one ) ;

        return result ;
    }

    void permute ( vector<int> & nums ,int pos  , vector<int> &num ) {
        int spot = num.size() ;
        //对于数字nums[pos]来说，有spot+1个空位可以插入
        for ( int i = 0 ; i <= spot ; ++ i ) {
            vector<int> one = num ;
            one.insert ( one.begin()+i,nums[pos]) ;
            if ( one.size() >= nums.size()) {
                result.emplace_back( one ) ;
            }
            else {
                permute ( nums,pos + 1 , one  ) ;
            }

        }
    }



    /*
    解法二：递归 遍历逐个放入数字，第1个有n种可能，第2个有n-1种可能，直到把数字放完，整个过程需要记录哪些数字已经使用过了，哪些还没有；
    12ms 62.41%
    */
    
    vector<vector<int>> permute(vector<int>& nums) {
        

        if ( nums.size() <= 0 ) return result ;
        if ( nums.size() == 1 ) {
            result.emplace_back( nums ) ;
            return result ;
        }
        
        unordered_map<int,bool> used ;
        for ( int i = 0 ; i < nums.size() ; ++ i ) {
            used.emplace( i , false ) ;
        }  
        
        vector<int> one ;
        permute(nums , one ,used) ;

        return result ;
    }

    void permute ( vector<int> & nums  , vector<int> &num,unordered_map<int,bool> used ) {
        for ( int i = 0 ; i < nums.size() ; ++ i ) {
            //没有使用过的数字才进行操作
            if ( used[i] == false ) {
                vector<int> one(num) ;   //拷贝一份，表示前面的排列都一样，本次第 one.size() 个位置 可以有 num.size() - one.size()个选择
                one.emplace_back( nums[i] ) ; //nums[i] 将作为排列的第 one[one.size()-1] 位

                if ( one.size() == nums.size() ) {
                    result.emplace_back( one ) ;
                }
                else {
                    used[i] = true  ;//做标记，因为该数字已经使用过了，在下层递归里面不可再使用
                    permute ( nums  , one , used ) ;
                     //复原，因为在本层循环里面，其他未用过的数字会作为排列的第 one.size() 位，该数字要作为未使用数字留给下层递归；
                    used[i] = false ;                   
                }
            }
        }
    }


    /*
    解法三：高赞答案:思路类似解法二，在固定的位置上枚举所有可能的结果，但效率更高。且空间复杂度更低；
    */
    vector<vector<int> > permute(vector<int> &num) {
	    vector<vector<int> > result;
	    
	    permuteRecursive(num, 0, result);
	    return result;
    }
    
    // permute num[begin..end]
    // invariant: num[0..begin-1] have been fixed/permuted
	void permuteRecursive(vector<int> &num, int begin, vector<vector<int> > &result) {
		if (begin >= num.size()) {
		    // one permutation instance
		    result.push_back(num);
		    return;
		}
		
		for (int i = begin; i < num.size(); i++) {
            //让后面的数都交换到begin这个位置上，枚举这个位置所有可能的情况
            //为啥不是从0开始，而是从begin开始对后面的数进行swap呢？举例说明
            //begin = 0,则这个位置包括0在那会交换0～num.size()-1共n次。
            //begin = 1，位置0的数已经确定了，需要排除。那么剩下的就是1～num.size()-1个数能放在begin这个位置上。可用的数字都在后面ß
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
    解法四：高赞答案:同解法三，在固定的位置上枚举所有可能的结果，递归传递非引用，空间复杂度更高；
    */
    vector<vector<int> > permute(vector<int> &num) {
	    vector<vector<int> > result;
	    
	    permuteRecursive(num, 0, result);
	    return result;
    }
     // permute num[begin..end]
    // invariant: num[0..begin-1] have been fixed/permuted
	void permuteRecursive(vector<int> num, int begin, vector<vector<int> > &result) {

		
		for (int i = begin; i < num.size(); i++) {
            //让后面的数都交换到begin这个位置上，枚举这个位置所有可能的情况
            //为啥不是从0开始，而是从begin开始对后面的数进行swap呢？举例说明
            //begin = 0,则这个位置包括0在那会交换0～num.size()-1共n次。
            //begin = 1，位置0的数已经确定了，需要排除。那么剩下的就是1～num.size()-1个数能放在begin这个位置上。可用的数字都在后面ß
            swap(num[begin], num[i]); 
            if ( (begin + 1) < num.size() ) {
                permuteRecursive(num, begin + 1, result);
            }
            else {
                result.push_back(num);
            }    
		    // 无需复原。因为每次都是传值到下层递归，当前到排列状态并没有被破坏
		    
		}
    }  
    
};
// @lc code=end

