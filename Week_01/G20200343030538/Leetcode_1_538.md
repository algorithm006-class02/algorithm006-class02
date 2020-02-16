### two_sum  
[Two Sum](https://leetcode.com/problems/two-sum/)

#### 解法一  
暴力求解，遍历两次，时间复杂度为O(N^2):

```Python
from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)):
            for j in range(i+1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]


if __name__ == '__main__':
    aim_list = [2, 7, 11, 15]
    solution = Solution()
    result = solution.twoSum(aim_list, 9)
    print(result)

[0, 1]
```

#### 解法二  
新建字典，来存储值和索引，时间复杂度为O(N):
```Python
from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        number_map = {}
        for i, num in enumerate(nums):
            if target - num in number_map:
                return [number_map[target-num], i]
            else:
                number_map[num] = i


if __name__ == '__main__':
    aim_list = [2, 7, 11, 15]
    solution = Solution()
    result = solution.twoSum(aim_list, 9)
    print(result)

[0, 1]
```

但是根据leetcode的Runtime看，用C++做的话会更快一些
```C++
#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> summap;
        vector<int> res(2);
        int n = nums.size();

        for (int i = 0; i < n; ++i) {
            if (summap.find(target - nums[i]) != summap.end()) {
                res[0] = summap[target - nums[i]];
                res[1] = i;
                break;
            } else {
                summap[nums[i]] = i;
            }
        }
        summap.clear();
        return res;
    }
};


int main(int argc, const char * argv[])
{
    Solution s;

    vector<int> nums = {2, 7, 11, 15};

    vector<int> ans = s.twoSum(nums, 9);
    int n = ans.size();
    for (int i = 0; i < n; i++) {
        cout << ans[i] << endl;
    }
    return 0;
}
```
