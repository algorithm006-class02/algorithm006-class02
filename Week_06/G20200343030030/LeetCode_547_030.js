/*
 * @lc app=leetcode.cn id=547 lang=javascript
 *
 * [547] 朋友圈
 */

// @lc code=start
/**
 * @param {number[][]} M
 * @return {number}
 */
var findCircleNum = function(M) {
    let n = M.length;
    if(n == 0){
        return 0;
    }
    let count = 0;
    let bfs = (i) => {
        let queue = [i];
        while(queue.length > 0){
            let adjacentPoint = queue.pop();
            for(let j = 0; j < n;j++){
                if(M[adjacentPoint][j] == 1 && !visited[j]){
                    visited[j] = true;
                    queue.push(j);
                }
            }
        }
    }
    let visited = {};
    for(let i = 0;i < n;i++){
        if(!visited[i]){
            bfs(i);
            count++;
        }
    }
    return count;
};

// @lc code=end

