<?php

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution
{

    /**
     * 解法一：先删除所有的0，然后在数组末尾增加相等数量的0
     * @param Integer[] $nums
     * @return NULL
     */
    function moveZeroes(&$nums)
    {
        $zeroNum = 0;
        foreach ($nums as $k => $v) {
            if ($v == 0) {
                unset($nums[$k]);
                $zeroNum++;
            }
        }
        while ($zeroNum) {
            $nums[] = 0;
            $zeroNum--;
        }
    }

    /**
     * 解法二：先定义好非0元素的位置，然后将数组中的非0元素迭代更新到定义好的位置
     * @param Integer[] $nums
     * @return NULL
     */
    function moveZeroes2(&$nums)
    {
        $index = 0;
        foreach ($nums as $k => $v) {
            if ($v != 0) {
                $nums[$index] = $v;
                if ($index != $k) {
                    $nums[$k] = 0;
                }
                $index++;
            }
        }
        return $nums;
    }
}