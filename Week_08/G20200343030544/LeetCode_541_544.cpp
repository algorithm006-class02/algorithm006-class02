class Solution {
public:
    string reverseStr(string s, int k) {
        int len = s.size();
        int step = k + k;
        //以2k作为递进单位
        for (int i = 0; i < len; i += step)
        {
            //交换前k个字符
            if (i + k < len)
                reverse(s.begin() + i, s.begin() + i + k);  //i+k不越界
            else
                reverse(s.begin() + i, s.end());  //i+k越界
        }
        return s;
    }
};
