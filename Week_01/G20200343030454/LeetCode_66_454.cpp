class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int i = digits.size()-1;
        int flag = 0;
        for (i;i>=0;i--){
            if (digits[i]+1>9){
                flag =1;
                digits[i]=0;
            }
            else {
                digits[i]++;
                flag = 0;
            }
            if (flag==0) break;
        }
        if (flag==1){
            digits.push_back(1);
            for (int j=digits.size()-1;j>0;j--){
                int temp,k=j-1;
                temp=digits[k];
                digits[k]=digits[j];
                digits[j]=temp;
            }
        }
        return digits;
    }
};