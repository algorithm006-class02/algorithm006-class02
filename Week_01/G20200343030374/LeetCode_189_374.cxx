// https://leetcode-cn.com/problems/rotate-array/

#include <vector>

using namespace std;

class Solution
{
public:
  // use a duplicate vector
  void rotate_1(vector<int> &nums, int k)
  {
    int size = nums.size();
    if (k == 0) return;
    vector<int> v;
    k = k % size;
    for (int i = size - k; i < size; ++i) {
      v.push_back(nums[i]);
    }
    for (int i = 0; i < size - k; ++i) {
      v.push_back(nums[i]);
    }
    for (int i = 0; i < size; ++i) {
      nums[i] = v[i];
    }
  }

  // O(n * k)
  // excess time limit
  void rotate_2(vector<int> &nums, int k) {
    k = k % nums.size();
    if (k == 0) return;
    while (k > 0) {
      int last = nums.back();
      for (int i = nums.size() - 2; i >= 0; --i) {
        nums[i + 1] = nums[i];
      }
      nums[0] = last;
      k--;
    }
  }

  // refer to official solution
  void rotate(vector<int> &nums, int k) {
    int size = nums.size();
    k = k % size;
    if (k == 0) return;
    reverse(nums, 0, size - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, size - 1);
  }
  void reverse(vector<int> &nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start++] = nums[end];
      nums[end--] = temp;
    }
  }
};