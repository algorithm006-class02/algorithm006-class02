class Solution {
public:
    int myAtoi(string str) {
        const char *p = str.c_str();
        for(; p != nullptr && *p == ' '; p++) {}
        if(p == nullptr || (*p != '+' && *p != '-' && (*p < '0' || *p > '9'))) {
            return 0;
        }
        int res = 0, flag = 1;
        if(*p == '-') {
            flag = -1;
            p++;
        } else if(*p == '+') {
            p++;
        }
        int MAX = (((1 << 30)-1)<<1) + 1;
        int MIN = -MAX-1;
        for(; '0' <= *p && *p <= '9'; p++) {
            if((MAX-(*p-'0')) / 10 < res) {
                if(flag == -1) {
                    return MIN;
                } else {
                    return MAX;
                }
            }
            (res *= 10) += *p-'0';
        }
        return res * flag;
    }
};