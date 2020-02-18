//简单一个数一个数的挪，超时
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        if (k>nums.size()) k%=nums.size();
        int len=nums.size();
        if (k!=0) {
            while (k>0) {
                int tmp=nums[len-1];
                for (int i=len-2; i>=0; i--) {
                    nums[i+1]=nums[i];
                }
                nums[0]=tmp;
                k--;
            }
        }
    }
};

//先将前k个翻转，再翻转后面的数组，最后再来个全数组翻转，完成。
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        if (k>nums.size()) k%=nums.size();
        int len=nums.size();
        reverse(nums.begin(),nums.end()-k);
        reverse(nums.end()-k,nums.end());
        reverse(nums.begin(),nums.end());
    }
};