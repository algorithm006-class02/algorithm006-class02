import java.util.HashSet;
import java.util.Set;

/**
 * @author : Hyuk
 * @description : LeetCode_36_536
 * @date : 2020/3/22 11:01 下午
 */
public class LeetCode_36_536 {

    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            Set<Character> m = new HashSet<>();
            Set<Character> n = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; j++){
                if(board[i][j] != '.' && !m.add(board[i][j])) {
                    return false;
                }
                if(board[j][i] != '.' && !n.add(board[j][i])) {
                    return false;
                }
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                if(board[rowIndex + j / 3][colIndex + j % 3]!='.' && !cube.add(board[rowIndex + j / 3][colIndex + j % 3])) {
                    return false;
                }
            }
        }
        return true;
    }
}
