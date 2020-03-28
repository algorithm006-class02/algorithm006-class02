/*
 * @lc app=leetcode.cn id=1122 lang=cpp
 *
 * [1122] 数组的相对排序
 */

// @lc code=start
class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        int myarr[1001] = {0};

        for (int t: arr1) {
            myarr[t]++;
        }

        int i = 0;
        for (int t2: arr2) {
            while(myarr[t2]-- > 0) {
                arr1[i++] = t2;
            }
        }
        
        int begin = i;
        for (int i = 0; i < 1001; i++) {
            while(myarr[i]-- > 0) {
                arr1[begin++] = i;
            }
        }
        return arr1;
    }
};
// @lc code=end

