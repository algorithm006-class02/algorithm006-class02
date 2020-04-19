class Solution {
public:
    int hammingWeight(uint32_t n) {
        int count = 0;
        while(n != 0)
        {
            ++count;
            n = n & (n - 1); //每次从n中去掉一个二进制1
        }
        return count;
    }
};
