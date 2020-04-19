<?php

/**
 * N皇后位运算版
 */
class Solution
{
    protected $count = 0;

    /**
     * @param Integer $n
     * @return String[][]
     */
    function solveNQueens($n)
    {
        if ($n < 1)
            return [];

        $this->dfs($n, 0, 0, 0, 0);
        return $this->count;
    }

    function dfs($n, $row, $col, $pie, $na)
    {
        if ($row >= $n) {
            $this->count++;
            return;
        }

        $bits = (~($col | $pie | $na)) & ((1 << $n) - 1);// 得到当前所有的空位
        while ($bits) {
            $p = $bits & -$bits;// 取最低位的1
            $bits = $bits & ($bits - 1);// 在p位置上放入皇后
            $this->dfs($n, $row + 1, $col | $p, ($pie | $p) << 1, ($na | $p) >> 1);
            // 不需要revert cols、pie、na的状态
        }
    }
}