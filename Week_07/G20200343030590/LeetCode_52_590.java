public class LeetCode_52_590 {

    public int backtrack(int row, int hills, int next_row, int dales, int count, int n) {
        // all columns available for this board,
        // i.e. n times '1' in binary representation
        // bin(cols) = 0b1111 for n = 4, bin(cols) = 0b111 for n = 3
        // [1 = available]
        int columns = (1 << n) - 1;

        if (row == n)   // if all n queens are already placed
            count++;  // we found one more solution
        else {
            // free columns in the current row
            // ! 0 and 1 are inversed with respect to hills, next_row and dales
            // [0 = taken, 1 = free]
            int free_columns = columns & ~(hills | next_row | dales);

            // while there's still a column to place next queen
            while (free_columns != 0) {
                // the first bit '1' in a binary form of free_columns
                // on this column we will place the current queen
                int curr_column = - free_columns & free_columns;

                // place the queen
                // and exclude the column where the queen is placed
                free_columns ^= curr_column;

                count = backtrack(row + 1,
                        (hills | curr_column) << 1,
                        next_row | curr_column,
                        (dales | curr_column) >> 1,
                        count, n);
            }
        }

        return count;
    }
    public int totalNQueens(int n) {
        return backtrack(0, 0, 0, 0, 0, n);
    }
}
