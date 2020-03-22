<?php
/**
 * 547. 朋友圈个数
 */
class Solution
{

    /**
     * 解法一：使用dfs
     * @param Integer[][] $grid
     * @return Integer
     */
    function findCircleNum($grid)
    {
        $row = $col = count($grid);
        $count = 0;
        for ($i = 0; $i < $row; $i++) {
            for ($j = 0; $j < $col; $j++) {
                if ($grid[$i][$j] == 1) {
                    $count++;
                }
                $this->changeGrid($i, $j, $row - 1, $col - 1, $grid);
            }
        }
        return $count;
    }

    function changeGrid($i, $j, $row, $col, &$grid)
    {
        if ($grid[$i][$j] == 1) {
            $grid[$i][$j] = 0;
        } else {
            return;
        }
        if ($i < $row) {
            $this->changeGrid($i + 1, $j, $row, $col, $grid);
        }
        if ($i > 0) {
            $this->changeGrid($i - 1, $j, $row, $col, $grid);
        }
        if ($j < $col) {
            $this->changeGrid($i, $j + 1, $row, $col, $grid);
        }
        if ($j > 0) {
            $this->changeGrid($i, $j - 1, $row, $col, $grid);
        }
    }

    /**
     * 方法二：并查集
     * @param $grid
     */
    function findCircleNum2($grid)
    {
        $len = count($grid);
        $p = array_pad([], $len, -1);
        for ($i = 0; $i < $len; $i++) {
            for ($j = 0; $j < $len; $j++) {
                if ($grid[$i][$j] = 1 && $i != $j) $this->_union($p, $i, $j);
            }
        }
        $count = 0;
        for ($i = 0; $i < $len; $i++) {
            if($p[$i] == -1) $count++;
        }
        $this->var_export($p);
        return $count;
    }

    function _union($p, $i, $j)
    {
        $p1 = $this->_parent($p, $i);
        $p2 = $this->_parent($p, $j);
        $p[$p2] = $p1;
    }

    function _parent($p, $i)
    {
        if($p[$i] == -1){
            return $i;
        }
        return $this->_parent($p, $p[$i]);
    }
}

$class = new Solution();
$m = [[1, 1, 0],
    [1, 1, 0],
    [0, 0, 1]];
$res = $class->findCircleNum2($m);