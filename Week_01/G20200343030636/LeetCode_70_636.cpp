/*
 * @lc app=leetcode.cn id=70 lang=cpp
 *
 * [70] 爬楼梯
 *
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (47.80%)
 * Likes:    834
 * Dislikes: 0
 * Total Accepted:    133.1K
 * Total Submissions: 278.4K
 * Testcase Example:  '2'
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 注意：给定 n 是一个正整数。
 * 
 * 示例 1：
 * 
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 
 * 示例 2：
 * 
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 
 * 
 */

// @lc code=start
class Solution {
    unordered_map < int ,int > done ;
public:
    /*
    解法一：典型的DP问题。
    1.定义状态：定义F(n) 是爬到第n阶到方法数。那么第n阶可以从第n-1阶爬1步，也可以从第n-2阶爬2步。由此得到爬到第n阶可以有2种方式。
    2.定义递题公式：递推公式为 F(n) = F(n-1)（从n-1爬1步） + F (n-2)（从n-2爬2步）
    可分为2种实现，自上向下或自下而上，自上而下用递归实现，自下而上用迭代实现。自上而下实现需使用备忘录，否则会超时
    4ms 61.39% 时间复杂度 
    */
    int climbStairs(int n) {
        if ( n < 0 ) return 0 ;
        if ( n <= 2 ) return n ;

        //return f ( n - 1 ) + f ( n - 2 ) ; //自上而下
        return F2 ( n ) ; //自下而上
    }
    //自上而下+备忘录
    int f ( int n ) {
        //递归终止条件
        if ( n <= 2 ) return n ; 
        
        if ( done.find( n ) != done.end() ) return done[ n ] ;

        done [ n ] = f ( n - 1 ) + f ( n - 2 ) ;

        return done [ n ] ;
    }
    
    //自下而上,时间复杂度O(n)，空间复杂度O(n)
    //0ms 100%
    int F1(int n) {
        vector<int> dp( n + 1 , 0 ) ; 
        dp [ 1 ] = 1 ;
        dp [ 2 ] = 2 ;
        for ( int i = 3 ; i <= n ; ++ i ) {
            dp [ i ] = dp [ i - 1 ] + dp [ i - 2 ] ;
        }

        return dp[ n ] ;
    }

    //自下而上,时间复杂度O(n)，空间复杂度O(1)
    //0ms 100%
    int F2(int n) {
         
        int one = 1 ,two = 2 ;
        int count = 0 ; 

        for ( int i = 3 ; i <= n ; ++ i ) {
            count = one + two ; //总数 = 走1步总数 + 走2步总数
            one = two ;         //更新
            two = count ;       //更新
        }

        return count ;
    }
};
// @lc code=end

