class Solution {
public:
    int hammingWeight(uint32_t n) {
        if(n==0){
            return 0;
        }
        int sum=0;
        while (n!=0){
            sum++;
            n&=(n-1);
        }
        return sum;
    }
};