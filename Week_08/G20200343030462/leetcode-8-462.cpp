class Solution {
public:
    int myAtoi(string str) {
        int result = 0;
        stringstream in(str);
        in >> result;
        return result;
    }
};
