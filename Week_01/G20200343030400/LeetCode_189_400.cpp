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
            int prev = nums[current];
            do {
                int next = (current + k) % size;
                int temp = nums[next];
                nums[next] = prev;
                current = next;
                prev = temp;
                ++count;
            } while (current != start);
        } 
    }
};
