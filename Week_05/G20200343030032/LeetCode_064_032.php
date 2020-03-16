<?php
/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 */

class Solution
{

    /**
     * 1、暴力递归
     * cost(i,j)=grid[i][j]+min(cost(i+1,j),cost(i,j+1))
     * @param Integer[][] $grid
     * @return Integer
     */
    function minPathSum($grid)
    {
        $row = count($grid);
        $col = count($grid[0]);
        return $this->cost(0, 0, $row, $col, $grid);
    }

    function cost($m, $n, $row, $col, $grid)
    {
        $arr = [];
        if ($m == $row || $n == $col) return 0;
        if ($m == $row - 1 && $n == $col - 1) {
            return $grid[$m][$n];
        }
        if (isset($arr[$m][$n])) {
            return $arr[$n][$n];
        } else {
            $down = $this->cost($m + 1, $n, $row, $col, $grid);
            $right = $this->cost($m, $n + 1, $row, $col, $grid);
            $arr[$m][$n] = $grid[$m][$n] + min($down, $right);
            return $arr[$m][$n];
        }
    }


    /**
     * 动态规划
     * @param $grid
     * @return mixed
     */
    function minPathSum2($grid)
    {
        $dp = [];
        $row = count($grid);
        $col = count($grid[0]);
        for ($i = 0; $i < $row; $i++) {
            for ($j = 0; $j < $col; $j++) {
                if ($i == 0 && $j == 0) {
                    $dp[$i][$j] = $grid[$i][$j];
                } else if ($i == 0) {
                    $dp[$i][$j] = $grid[$i][$j] + $dp[$i][$j - 1];
                } else if ($j == 0) {
                    $dp[$i][$j] = $grid[$i][$j] + $dp[$i - 1][$j];
                } else {
                    $dp[$i][$j] = $grid[$i][$j] + min($dp[$i - 1][$j], $dp[$i][$j - 1]);
                }
            }
        }
        return $dp[$row - 1][$col - 1];
    }

    function minPathSum3($grid)
    {
        $dp = [];
        $row = count($grid);
        $col = count($grid[0]);
        for ($i = 0; $i < $row; $i++) {
            for ($j = 0; $j < $col; $j++) {
                if ($i == 0 && $j == 0) {
                    $dp[$j] = $grid[$i][$j];
                } else if ($i == 0) {
                    $dp[$j] = $grid[$i][$j] + $dp[$j - 1];
                } else if ($j == 0) {
                    $dp[$j] = $grid[$i][$j] + $dp[$j];
                } else {
                    $dp[$j] = $grid[$i][$j] + min($dp[$j], $dp[$j - 1]);
                }
            }
        }

        return $dp[$col - 1];
    }
}

$class = new Solution();
$path = [
    [1, 3, 1],
    [1, 5, 1],
    [4, 2, 1]
];
$res = $class->minPathSum3($path);
var_dump($res);