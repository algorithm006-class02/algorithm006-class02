[Assign Cookies](https://leetcode.com/problems/assign-cookies/)  

#### 题解
```Python
class Solution:
    def lemonadeChange(self, bills):
        """
        :type bills: List[int]
        :rtype: bool
        """
        five = ten = 0
        for i in bills:
            if i == 5:
                five += 1
            elif i == 10:
                five, ten = five - 1, ten + 1
            elif ten > 0:
                five, ten = five - 1, ten - 1
            else:
                five -= 3
            if five < 0:
                return False
        return True


def main():
    coin = [5, 5, 5, 10, 20]
    solution = Solution()
    result = solution.lemonadeChange(coin)
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
    bool lemonadeChange(vector<int>& bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) ++five;
            else if (bill == 10) { --five; ++ten; }
            else if (ten > 0) { --ten; --five; }
            else five -= 3;
            if (five < 0) return false;
        }
        return true;
    }
};


int main(int argc, const char * argv[])
{
    Solution s;
    vector<int> coin = {5, 5, 5, 10, 20};
    bool res = s.lemonadeChange(coin);
    cout << res << endl;
    return 0;
}
```
