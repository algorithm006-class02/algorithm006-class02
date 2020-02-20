// https://leetcode-cn.com/problems/plus-one/
#include <vector>

using namespace std;

class Solution {
  public:
    // a common way: + x
    vector<int> plusOne_1(vector<int> &digits) {
      int carrayBit = 1;
      for (int i = digits.size() - 1; i >= 0; --i) {
        int sum = digits[i] + carrayBit;
        if (sum < 10) {
          digits[i] = sum;
          return digits; 
        }
        carrayBit = sum / 10;
        digits[i] = sum % 10;
      }
      digits.insert(digits.begin(), carrayBit);
      return digits;
    }
    vector<int> plusOne(vector<int> &digits) {
      for (int i = digits.size() - 1; i >= 0; --i) {
        // note the priority of operations:
        // first: digits[i] < 9
        // second: digits[i]++
        if (digits[i]++ < 9) {
          return digits;
        }
        digits[i + 1] = 0;
      }
      digits[0] = 1;
      digits.push_back(0);
      return digits;
    }
};