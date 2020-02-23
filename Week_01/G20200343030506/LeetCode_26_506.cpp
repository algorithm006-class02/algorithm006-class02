//方法一
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if(nums.size()==0) return 0;
        int i=0;
        for(int j=1;j<nums.size();j++)
        {
            if(nums[i]!=nums[j])
            {
                ++i;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
};

//方法二

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
       if(nums.size()==0) return 0;
        int j=0;
        for (int i=0;i<nums.size()-1;i++){
            if(nums[i]!=nums[i+1]){
                j=j+1;
                nums[j]=nums[i+1];  
            }
        }
        return j+1;
    }
};