/*
 * @lc app=leetcode.cn id=200 lang=javascript
 *
 * [200] 岛屿数量
 *
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (46.97%)
 * Likes:    417
 * Dislikes: 0
 * Total Accepted:    68K
 * Total Submissions: 142.7K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给定一个由 '1'（陆地）和
 * '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 
 * 示例 1:
 * 
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * 输出: 3
 * 
 * 
 */

// @lc code=start
/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    let m = grid.length;
    if(m == 0){
        return 0;
    }
    let n = grid[0].length;
    let count = 0;
    let parent = [];
    let rank = [];


    let find = (p) => {
        while(p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    let union = (p,q) => {
        let rootP = find(p);
        let rootQ = find(q);
        if(rootP == rootQ){
            return;
        }
        if(rank[rootP] > rank[rootQ]){
            parent[rootQ] = rootP;
        }else if(rank[rootP] < rank[rootQ]){
            parent[rootP] = rootQ;
        }else{
            parent[rootP] = rootQ;
            rank[rootQ]++;
        }
        count--;
    }

    for(let i = 0;i < m;i++){
        for(let j = 0;j < n;j++){
            if(grid[i][j] == 1){
                parent[i * n + j] = i * n + j;
                count++;
            }
            rank[i * n + j] = 0;
        }
    }

    for(var i = 0;i<m;i++){
        for(var j = 0;j<n;j++){
            if(grid[i][j] == 1){
                grid[i][j] = 0;
                i-1>=0 && grid[i-1][j] == 1 && union(i*n + j,(i-1)*n + j);
                j-1>=0 && grid[i][j-1] == 1 && union(i*n + j,i*n + j-1);
                i+1<m && grid[i+1][j] == 1 && union(i*n + j,(i+1)*n + j);
                j+1<n && grid[i][j+1] == 1 && union(i*n + j,i*n + j+1);
            }
        }
    }
    return count;
};
// @lc code=end

