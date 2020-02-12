//42
//https://leetcode-cn.com/problems/trapping-rain-water

class Solution {
public:
    int trap(vector<int>& height) {
        if (height.size() <= 2) return 0;
        int water = 0;
        int left = 0, right = height.size() - 1;
        int min_left = height[left], min_right = height[right];
        while (left < right) {
            if (min_left < min_right) {
                ++left;
                if (height[left] < min_left) {
                    water += (min_left - height[left]);
                } else {
                    min_left = height[left];
                }
            } else {
                --right;
                if (height[right] < min_right) {
                    water += (min_right - height[right]);
                } else {
                    min_right = height[right];
                }
            }
        }
        return water;
    }
};
