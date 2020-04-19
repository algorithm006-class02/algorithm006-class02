52. N皇后 II
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



上图为 8 皇后问题的一种解法。

给定一个整数 n，返回 n 皇后不同的解决方案的数量。

示例:

输入: 4
输出: 2
解释: 4 皇后问题存在如下两个不同的解法。
[
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]

### solution


bitmap
```java
class Solution{
    public int backtrack(int row,int hills,int next_row,int dales,int count int n){
    /** 
     row: 当前放置皇后的行号
     hills: 主对角线占据情况 [1 = 被占据，0 = 未被占据]
     next_row: 下一行被占据的情况 [1 = 被占据，0 = 未被占据]
     dales: 次对角线占据情况 [1 = 被占据，0 = 未被占据]
     count: 所有可行解的个数
     */

    // 棋盘所有的列都可放置，
    // 即，按位表示为 n 个 '1'
    // bin(cols) = 0b1111 (n = 4), bin(cols) = 0b111 (n = 3)
    // [1 = 可放置]
    int columns = 1<<n -1;
    if(row == n)
        count++;
    else{
        // 当前行可以用的列：[1,0]
        int free_columns = colmns &~(hills|next_row|dales);
        while(free_columns!=0){
            int curr_columns  = -free_columns & free_columns;
            free_columns ^= curr_columns;
            count = backtrack( row + 1,
                (hills | curr_column) << 1,
                next_row | curr_column,
                (dales | curr_column) >> 1,
                count, n)
        }
        return count;
    }

    public static void main(int n){
        retrun backtrack(0,0,0,0,0,n);
    }

    }
}
```

