//类似于求柱状图中最大的矩形问题，用栈的方法
class Solution {
public:
    int trap(vector<int>& height)
    {
        int ans = 0, current = 0;
        stack<int> left;
        while (current < height.size()) {
            while (!left.empty() && height[current] > height[left.top()]) {
                int top = left.top();
                left.pop();
                if (left.empty())
                    break;
                int distance = current - left.top() - 1;
                int bounded_height = min(height[current], height[left.top()]) - height[top];
                ans += distance * bounded_height;
            }
            left.push(current++);
        }
        return ans;
    }
};