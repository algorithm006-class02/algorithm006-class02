//从终点开始判断能否到达，直到上一步回到原点则成功，回不到原点就失败，贪心算法，递归
class Solution {
public:
    bool res = false;
    bool canJump(vector<int>& nums) {
        int lastSite=nums.size()-1;
        int nearest=nums.size()-2;
        jump(nums, lastSite, nearest);
        return res;
    }
    void jump(vector<int>& nums, int lastSite, int nearest) {
        if (lastSite==0) {
            res=true;
        };
        for (int i=nearest; i>=0; i--) {
            if (i+nums[i]<lastSite) {
                res=false;
            } else {
                lastSite=i;
                nearest=lastSite-1;
                return jump(nums, lastSite, nearest);
            }
        }
        return;
    }
};

//从起点开始，判断最远跳跃距离，直到跳不动为止
class Solution {
public:
    bool canJump(vector<int>& nums) {
        int k = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (i > k) return false;
            k = max(k, i + nums[i]);
        }
        return true;
    }
};