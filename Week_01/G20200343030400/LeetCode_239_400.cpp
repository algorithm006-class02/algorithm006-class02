//239
//https://leetcode-cn.com/problems/sliding-window-maximum

class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        int size = nums.size();
        if (size * k == 0) return {};
        if (k == 1) return nums;
        if (k > size) k = size;

        vector<int> ans;
        deque<int> dq;
        for (int i = 0; i < size; ++i) {
            while (!dq.empty() && nums[i] >= nums[dq.back()])
                dq.pop_back();
            dq.push_back(i);
            if (dq.front() + k == i)
                dq.pop_front();
            if (i >= k - 1)
                ans.push_back(nums[dq.front()]);
        }
        return ans;
    }
};
