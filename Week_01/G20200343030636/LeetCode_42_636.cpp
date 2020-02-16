/*
 * @lc app=leetcode.cn id=42 lang=cpp
 *
 * [42] 接雨水
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (48.43%)
 * Likes:    858
 * Dislikes: 0
 * Total Accepted:    53.1K
 * Total Submissions: 109.4K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 
 * 
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢
 * Marcos 贡献此图。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 
 */

// @lc code=start
class Solution {
public:
    /*
    解法一：分层计算，先算第一层，再算第二层....依此类推。每一层能接住雨水的情况是两边有柱子(1)，且中间是没有柱子(0)，这样计算中间有多少个
    连续的0即可。然后将高度全部-1.计算第二层，直到该层的1个数<2。此方法遇到较大的数会需要计算的层级非常多，效率较低，无法AC
    pass 313 case，314 case Time Limit； 
    */
   /*
    int trap(vector<int>& height) {
        if( height.size() < 3 ) return 0 ;

        int can = 0 ;
        int water = 0 ;
        int start = -1 ;
        int first = -1 ;

        for ( int i = 0 ; i < height.size() ; ) {
            if ( height[i] > 0 ) {

                start =  i  ;

                height[i] -= 1 ;

                if( height[i] > 0 ) {
                    can ++ ;  
                    first = first == - 1 ? i : first ; 
                }

                while (( ++ i ) < height.size() && height[i] == 0 ) {
                    cout << i  << endl ;
                    //water ++ ;
                }

                if( i >= height.size() ) { //本层已经计算完毕
                    cout << "water = " << water << endl;
                    for(auto n : height )
                        cout << n << "," ;
                    cout << endl;

                    if(can > 1) {
                        i = first ; //重头开始
                    }
                    else { //结束
                        break ;
                    }
                    
                }
                else { //遇到后面第一个height[i] > 0
                    water += ( i - start - 1 );
                }    
            } 
            else {
                ++ i ;
            }        

        }

        return water ;
    }
    */
    /*
    解法二：高赞答案，不分层，直接计算
    4ms 94.98%
    */
    int trap(vector<int>& height) {
        if( height.size() < 3 ) return 0 ;

        int left = 0 , right = height.size() - 1 , water = 0 ;

        int maxleft = 0 , maxright = 0 ;
        while ( left <= right ) {
            if( height[left] <= height[right] ) {
                if( height[left] >= maxleft) {
                    maxleft = height[left] ;
                }
                else {
                    water += maxleft-height[left] ;
                }
                left ++ ;
            }
            else {
                if( height[right] >= maxright ) {
                    maxright = height[right] ;
                }
                else {
                    water += maxright - height[right] ;    
                }
                right -- ;
            }
            //cout << left << "," << right << endl;

        }
        return water ;
    }


    /*
    高赞答案：
    */
    int trap(vector<int>& height) {
        int l = 0, r = height.size()-1, level = 0, water = 0;
        while (l < r) {
            int lower = height[height[l] < height[r] ? l++ : r--];
            level = max(level, lower);
            water += level - lower;
        }
        return water ;
    }
};
// @lc code=end

