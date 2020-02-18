#include<iostream>
#include<string>
#include<cctype>
#include<algorithm>
#include<vector>
using namespace std;

//没有采用自顶向下的编程方法
class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        vector<int> record;
        for(int num:nums){
            if(num==0){
                record.push_back(0);
            }else{
                record.push_back(1);
            }
        }
        vector<int> tmp;

        for (int i = 0; i < nums.size();i++){
            if(record[i]==1){
                tmp.push_back(nums[i]);
            }
        }

        for (int i = 0; i <nums.size();i++){
            if(record[i]==0){
                tmp.push_back(nums[i]);
            }
        }
        nums = vector<int>(tmp);
    }
};

int main()
{
    vector<int> obj = {0,1,0,3,12};
    Solution A = Solution();
    A.moveZeroes(obj);
    printf("1");
}