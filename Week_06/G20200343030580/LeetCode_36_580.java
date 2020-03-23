class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new Set[9];
        Set<Character>[] columns = new Set[9];
        Set<Character>[] subs = new Set[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            subs[i] = new HashSet<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Character c = board[i][j];
                if (isUnValidate(c, i, rows) || isUnValidate(c, j, columns) || isUnValidate(c, (i / 3) * 3 + j / 3, subs)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isUnValidate(Character c, int index, Set<Character>[] set) {
        if (c == '.') {
            return false;
        }
        if (set[index].contains(c)) {
            return true;
        } else {
            set[index].add(c);
            return false;
        }
    }
}
