#include <iostream>
#include <vector>
#include <map>

using namespace std;

class Solution {

public:
    vector<int> twoSum(vector<int>& nums, int target) {
        std::map<int, int> map;
        std::vector<int> result;
        for (int i = 0; i < nums.size(); i++) {
            if (map[target - nums[i]] != 0) {
                result.push_back(map[target - nums[i]] - 1);
                result.push_back(i);
                return result;
            }
            map[nums[i]] = i + 1;
        }
        return result;
    }
};

int main() {
	Solution s;
	vector<int> result;
	vector<int> nums;
	nums.push_back(2);
	nums.push_back(7);
	nums.push_back(11);
	nums.push_back(15);
	int target = 9;
	result = s.twoSum(nums, target);
	for (vector<int>::iterator it = result.begin(); it != result.end(); it++) {
		cout << *it << " ";
	}
	return 0;
}