<?php
/**
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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lemonade-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution
{

    /**
     * 贪心算法，优先使用最大面额的现金找零
     * @param Integer[] $bills
     * @return Boolean
     */
    function lemonadeChange($bills)
    {
        $wallet = [5 => 0, 10 => 0, 20 => 0];
        foreach ($bills as $money) {
            switch ($money) {
                case 5:
                    $wallet[5]++;
                    break;
                case 10:
                    if ($wallet[5] > 0) {
                        $wallet[5]--;
                        $wallet[10]++;
                    } else {
                        return false;
                    }
                    break;
                case 20:
                    if ($wallet[10] > 0 && $wallet[5] > 0) {
                        $wallet[10]--;
                        $wallet[5]--;
                        // $wallet[20]++;
                    } else if ($wallet[5] > 2) {
                        $wallet[5] -= 3;
                        // $wallet[20]++;
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}

$class = new Solution();
$bills = [5, 5, 5, 10, 20];
$bills = [5, 5, 10, 10, 20];
$res = $class->lemonadeChange($bills);
var_dump($res);