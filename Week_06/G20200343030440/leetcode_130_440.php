<?php
class Solution {

    /**
     * @param String[][] $board
     * @return NULL
     */
    function solve(&$board) {
        if (empty($board)) return;

        $row = count($board) - 1;
        $col = count($board[0]) - 1;

        // 递归替换第一行和最后一行边界
        for ($j = 0; $j <= $col; $j++) {
            $this->dfs($board, 0, $j, $row, $col);
            $this->dfs($board, $row, $j, $row, $col);
        }

        // 递归处理第一列和最后一列边界
        for ($i = 0; $i <= $row; $i++) {
            $this->dfs($board, $i, 0, $row, $col);
            $this->dfs($board, $i, $col, $row, $col);
        }

        // 遍历，把O变X, *变O
        for ($x = 0; $x <= $row; $x++) {
            for ($y = 0; $y <= $col; $y++) {
                if ($board[$x][$y] == 'O') $board[$x][$y] = 'X';
                if ($board[$x][$y] == '*') $board[$x][$y] = 'O';
            }
        }

        return;
    }

    // 深度优先遍历，把当前位置联通的O都变为*
    public function dfs(&$board, $i, $j, $row, $col)
    {
        if ($i < 0 || $i > $row || $j < 0 || $j > $col || $board[$i][$j] != 'O') return;

        $board[$i][$j] = '*';
        $this->dfs($board, $i - 1, $j, $row, $col);
        $this->dfs($board, $i + 1, $j, $row, $col);
        $this->dfs($board, $i, $j - 1, $row, $col);
        $this->dfs($board, $i, $j + 1, $row, $col);
    }
}
