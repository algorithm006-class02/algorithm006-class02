<?php

/**
 * 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 */
class Solution
{

    /**
     * 使用贪心算法，低价买入高价卖出
     * 1、单独交易日： 设今天价格 p1、明天价格 p2，则今天买入、明天卖出可赚取金额 p_2 - p_1p
     * ​
     * （负值代表亏损）。
     * 2、连续上涨交易日： 设此上涨交易日股票价格分别为 p1, p2, ... , pn
     * ​
     * ，则第一天买最后一天卖收益最大，即 pn - p1
     * ​
     * 等价于每天都买卖，即 p_n - p_1=(p_2 - p_1)+(p_3 - p_2)+...+(p_n - p_{n-1})
     * pn−p1=(p2 − p1)+(p3 − p2)+...+(pn − pn−1)。
     * 3、连续下降交易日： 则不买卖收益最大，即不会亏钱。
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/best-time-to-buy-and-sell-stock-ii-zhuan-hua-fa-ji/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param Integer[] $prices
     * @return Integer
     */
    function maxProfit($prices)
    {
        $len = count($prices);
        $profit = 0;
        for ($i = 1; $i < $len; $i++) {
            $tmp = $prices[$i] - $prices[$i - 1];
            if($tmp > 0){
                $profit += $tmp;
            }
        }
        return $profit;
    }
}

$class = new Solution();
$prices = [1, 2, 3, 4, 5];
$prices = [7, 1, 5, 3, 6, 4];
$prices = [7, 6, 4, 3, 1];
$res = $class->maxProfit($prices);
var_dump($res);
