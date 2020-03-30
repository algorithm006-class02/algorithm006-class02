class Solution {
public:
    vector<int> countBits(int num) {
        vector<int> result;
        for(int i = 0; i <= num; ++i)
        {
            result.push_back(popcount(i));
        }
        return result;
    }

private:
    //统计一个数字中有多少个二进制1
    int popcount(int n)
    {
        int result = 0;
        while (n != 0)
        {
            ++result;
            n = n & (n - 1);
        }
        return result;
    }
};
