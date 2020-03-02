<?php
/**
 * 计算岛屿数量
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水包围。
 */

class Solution
{

    /**
     * 先找到第一个为陆地的元素，陆地数量加1，然后把相邻的区域改成水
     * @param String[][] $grid
     * @return Integer
     */
    function numIslands($grid)
    {
        $islandNum = 0;
        if (empty($grid)) {
            return $islandNum;
        }

        $row = count($grid);
        $col = count($grid[0]);
        for ($i = 0; $i < $row; $i++) {
            for ($j = 0; $j < $col; $j++) {
                if ($grid[$i][$j] == 1) {
                    $islandNum++;
                }
                $this->changeGrid($i, $row, $j, $col, $grid);
            }
        }
        return $islandNum;
    }

    function changeGrid($i, $row, $j, $col, &$grid)
    {
        // terminal
        if ($grid[$i][$j] == 0) {
            return;
        } else {
            $grid[$i][$j] = 0;
        }

        if ($i + 1 < $row) {
            $this->changeGrid($i + 1, $row, $j, $col, $grid);
        }
        if ($i > 0) {
            $this->changeGrid($i - 1, $row, $j, $col, $grid);
        }

        if ($j + 1 < $col) {
            $this->changeGrid($i, $row, $j + 1, $col, $grid);
        }
        if ($j > 0) {
            $this->changeGrid($i, $row, $j - 1, $col, $grid);
        }
    }
}


$class = new Solution();
$grid = [
    ["1", "1", "1"],
    ["0", "1", "0"],
    ["1", "1", "1"]
];

$num = $class->numIslands($grid);
var_dump($num);