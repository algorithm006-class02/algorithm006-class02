[Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)  

主要在` You may complete as many transactions as you like`这句话，就是说不限次买入和卖出。所以从第二天开始，如果当前的价格比之前高，就计算差值，直到遍历完整个数组。  

#### 题解
```Python
from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices or len(prices) == 1:
            return 0

        res = 0
        for i in range(1, len(prices)):
            if prices[i] > prices[i - 1]:
                res += prices[i] - prices[i - 1]
        return res


def main():
    nums = [7, 1, 5, 3, 6, 4]
    solution = Solution()
    result = solution.maxProfit(nums)
    print(result)


if __name__ == '__main__':
    main()

```

```C++
#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;


class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        int res = 0;
        for (int i = 1; i < n; ++i) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
};


int main(int argc, const char * argv[])
{
    Solution s;
    vector<int> nums = {7,1,5,3,6,4};

    int result = s.maxProfit(nums);
    cout << result << endl;
    return 0;
}
```
