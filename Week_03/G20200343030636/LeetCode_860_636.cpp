/*
 * @lc app=leetcode.cn id=860 lang=cpp
 *
 * [860] 柠檬水找零
 *
 * https://leetcode-cn.com/problems/lemonade-change/description/
 *
 * algorithms
 * Easy (53.71%)
 * Likes:    94
 * Dislikes: 0
 * Total Accepted:    15.8K
 * Total Submissions: 29.3K
 * Testcase Example:  '[5,5,5,10,20]'
 *
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 * 
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * 
 * 注意，一开始你手头没有任何零钱。
 * 
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 * 
 * 示例 1：
 * 
 * 输入：[5,5,5,10,20]
 * 输出：true
 * 解释：
 * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
 * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
 * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
 * 由于所有客户都得到了正确的找零，所以我们输出 true。
 * 
 * 
 * 示例 2：
 * 
 * 输入：[5,5,10]
 * 输出：true
 * 
 * 
 * 示例 3：
 * 
 * 输入：[10,10]
 * 输出：false
 * 
 * 
 * 示例 4：
 * 
 * 输入：[5,5,10,10,20]
 * 输出：false
 * 解释：
 * 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
 * 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
 * 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
 * 由于不是每位顾客都得到了正确的找零，所以答案是 false。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= bills.length <= 10000
 * bills[i] 不是 5 就是 10 或是 20 
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    /*
    解法一：用hash记录已收钞票的情况
    24ms 27.48%
    */
    bool lemonadeChange(vector<int>& bills) {
        unordered_map<int,int> get ;
        for ( auto num : bills ) {
            //5 元
            if ( num == 5 ) {
                get[5] ++ ;
            }
            //10 元
            else if ( num == 10) {
                //没有5元或数量不够
                if ( get.find(5) == get.end() || get[5] == 0 ) return false ;
                get[5] -- ;
                get [10] ++ ;
            }
            //20 元
            else {
                //没有5元必然无法找零
                if ( get.find(5) == get.end() || get[5] == 0 ) return false ;
                
                //只有5元，必须大于3
                if ( (get.find(10) == get.end() || get[10] == 0 ) && get[5] >=3 ) {
                    get[5] -= 3;
                }
                //只有5元且数量不足3，必须用10元来找零
                else if(get.find(10) == get.end() || get[10] == 0 ) {
                    return false ;
                }
                //有10元
                else {
                    get[5] -=1 ;
                    get[10] -= 1;
                }
                get[20]++;
            }

        }

        return true ;
    }


    /*
    社区高赞解法，当您收到5或10的账单时，您只有一个选项：要么不返回（当收到5）要么返回5（当收到10）的账单。
    但是当你收到20的账单时，你有两个选择：退还一个5元账单和一个10元账单，或者只返回3个 5元账单。 正确的想法是前者更好，但为什么呢？ 
    答案是10元账单只有在你收到20元账单时才能在退还时使用，但是当你收到20张账单和10张账单时，你都可以退还5元账单。所以说， 在某种程度上， 
    5元账单比15元账单更“珍贵” 。
    */
   int lemonadeChange(vector<int> bills) {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) five++;
            else if (i == 10) five--, ten++;
            else if (ten > 0) ten--, five--;
            else five -= 3;
            if (five < 0) return false;
        }
        return true;
    }
};
// @lc code=end

