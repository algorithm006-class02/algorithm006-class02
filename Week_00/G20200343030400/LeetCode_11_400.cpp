//11-container-with-most-water

class Solution {
public:
    int maxArea(vector<int>& height) {
        int max_area = 0, area = 0;
        int left = 0, right = height.size() - 1;
        while (left < right) {
            area = min(height[left], height[right]) * (right - left);
            max_area = max(area, max_area);
            if (height[left] < height[right])
                ++left;
            else if (height[left] > height[right])
                --right;
            else {
                ++left;
                --right;
            }         
        }
        return max_area;
    }
};
