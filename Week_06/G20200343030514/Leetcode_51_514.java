class Solution {
    
    // 判断对角线的技巧很好 其实就是两个线性方程 y = x + a / y = -x + a ==> y - x = a / y + x = a
    // => row - column = a / row + column = a
    
    private List<List<String>> result = new ArrayList<>();
    private Set<Integer> diffSet = new HashSet<>();
    private Set<Integer> sumSet = new HashSet<>();
    private Set<Integer> columnSet = new HashSet<>();


    public List<List<String>> solveNQueens(int n) {
        List<String> tmp = new ArrayList<>();
        helper(n, 0, tmp);
        return result;        
    }
    
    private void helper(int n, int row, List<String> tmp) {
        
        if (row == n) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        
        for (int column = 0; column < n; column++) {
            
            if (columnSet.contains(column) || diffSet.contains(row - column) || sumSet.contains(row + column)) {
                continue;
            }
            
            columnSet.add(column);
            diffSet.add(row - column);
            sumSet.add(row + column);
            
            tmp.add(createLine(column, n));
            
            helper(n, row + 1, tmp);
            
            tmp.remove(tmp.size() - 1);
            columnSet.remove(column);
            diffSet.remove(row - column);
            sumSet.remove(row + column);
                   
        }
        
    }
    
    private String createLine(int index, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == index) {
                stringBuilder.append("Q");
            } else {
                stringBuilder.append(".");
            }
        }
        return stringBuilder.toString();   
    }
    
    
}
