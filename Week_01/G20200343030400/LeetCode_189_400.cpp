//189
//https://leetcode-cn.com/problems/rotate-array/

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int size = nums.size();
        if (size == 0) return; 
        k = k % size;
        if (k == 0) return;
        for (int start = 0, count = 0; count < size; ++start) {
            int current = start;
            int prev_val = nums[current];
            do {
                int next = (current + k) % size;
                int temp_val = nums[next];
                nums[next] = prev_val;
                current = next;
                prev_val = temp_val;
                ++count;
            } while (current != start);
        } 
    }
};
