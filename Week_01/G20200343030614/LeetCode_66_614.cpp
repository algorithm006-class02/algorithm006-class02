//两个解法思路一样，第二个利用不同的运算符，代码更简洁
class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        for (int i=digits.size()-1; i>=0; i--) {
            digits[i]++;
            if (digits[i]>9) {
                digits[i]=0;
            } else {
                return digits;
            }
        }
        digits.insert(digits.begin(),1);
        return digits;
    }
};


class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        for (int i=digits.size()-1; i>=0; i--) {
            if (++digits[i]%=10)
                return digits;
        }
        digits.insert(digits.begin(),1);
        return digits;
    }
};