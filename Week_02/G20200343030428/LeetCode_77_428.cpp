/*
 * @lc app=leetcode.cn id=77 lang=cpp
 *
 * [77] 组合
 */

// @lc code=start

class Solution {
private:
    vector<vector<int>> result;
public:
    // 入口函数
    vector<vector<int>> combine(int n, int k) {
        if(k <= 0||n <= 0)  //起始条件有误直接return
            return result;
            
        vector<int> path;
        backtrack(1, k, n, path);   // 1-n k个数 放到path里
        return result;
    }

    void backtrack(int start, int k, int n, vector<int>& path){ // 例: k = 2 n = 4
        if(path.size() == k){   //path.size() == 2 的时候是想要的
            result.push_back(path); //  退出循环
            return;
        }
        // n + 1 - (k - path.size()) 是条件：保证无重复
        // [1,2] [1,3] [1,4]
        // [2,3] [2,4]
        // [3,4]
        for(int i = start; i <= n + 1 - (k - path.size()); i++){
            path.push_back(i); // i 一开始就是[1 - 3]
            backtrack(i + 1, k, n, path); // 放第二个数[2 - 4]
            path.pop_back(); 
        }
    }

};
// @lc code=end

