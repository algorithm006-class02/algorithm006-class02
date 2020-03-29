[Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits/)  

```Python
class Solution:
    def hammingWeight(self, n: int) -> int:
        count = 0
        while n > 0:
            n &= n - 1
            count += 1
        return count
```

```C++
class Solution {
public:
    int hammingWeight(uint32_t n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            ++res;
        }
        return res;
    }
};
```
