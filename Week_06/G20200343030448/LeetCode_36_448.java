package G20200343030448;

import java.util.Enumeration;
import java.util.HashMap;

public class LeetCode_36_448 {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char pick = board[i][j];
                if (pick != '.') {
                    int num = (int) pick;
                    int boxindex = (i / 3) * 3 + (j / 3);
                    rows[i].put(num, rows[i].getOrDefault(num, 0) + 1);
                    columns[j].put(num, columns[j].getOrDefault(num, 0) + 1);
                    boxes[boxindex].put(num, boxes[boxindex].getOrDefault(num, 0) + 1);
                    if (rows[i].get(num) > 1 || columns[j].get(num) > 1 || boxes[boxindex].get(num) > 1)
                        return false;
                }
            }
        }
        return true;
    }
}
