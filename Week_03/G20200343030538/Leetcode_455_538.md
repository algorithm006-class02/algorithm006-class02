[Assign Cookies](https://leetcode.com/problems/assign-cookies/)  

#### 题解
```Python
from typing import List


class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        if not g or not s:
            return 0

        g.sort()
        s.sort()

        child = res = 0
        for cookie in s:
            if child >= len(g):
                return res
            if cookie >= g[child]:
                res += 1
                child += 1
        return res


def main():
    p1 = [1, 2, 3]
    p2 = [1, 1]
    solution = Solution()
    result = solution.findContentChildren(p1, p2)
    print(result)


if __name__ == '__main__':
    main()

```

```C++
#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>
using namespace std;


class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        size_t j = 0;
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        for (size_t i = 0; i < s.size() && j < g.size(); ++i) {
            if (s[i] >= g[j]) ++j;
        }
        return j;
    }
};


int main(int argc, const char * argv[])
{
    Solution s;
    vector<int> p1 = {1, 2, 3};
    vector<int> p2 = {1, 1};
    int res = s.findContentChildren(p1, p2);
    cout << res << endl;
    return 0;
}
```
