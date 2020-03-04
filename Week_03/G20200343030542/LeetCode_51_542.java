
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {
    private boolean[] visitedCols;
    private boolean[] visitedDia1;
    private boolean[] visitedDia2;

    public List<List<String>> solveNQueens(int n) {
        visitedCols = new boolean[n];
        visitedDia1 = new boolean[2 * n - 1];
        visitedDia2 = new boolean[2 * n - 1];

        List<List<String>> result = new ArrayList<>();
        putNQueen(n, 0, new ArrayList<>(), result);
        return result;
    }

    private void putNQueen(int n, int index, List<Integer> row, List<List<String>> result) {
        if (index == n) {
            result.add(generateBoard(n, row));
        }
        for (int i = 0; i < n; i++) {
            if (!visitedCols[i] && !visitedDia1[index + i] && !visitedDia2[index - i + n - 1]) {
                row.add(i);
                visitedCols[i] = true;
                visitedDia1[index + i] = true;
                visitedDia2[index - i + n - 1] = true;

                putNQueen(n, index + 1, row, result);
                visitedCols[i] = false;
                visitedDia1[index + i] = false;
                visitedDia2[index - i + n - 1] = false;
                row.remove(row.size() - 1);
            }
        }
    }

    private List<String> generateBoard(int n, List<Integer> row) {
        List<String> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            char[] achars = new char[n];
            Arrays.fill(achars, '.');
            achars[row.get(i)] = 'Q';
            list.add(new String(achars));
        }
        return list;
    }
}
