class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        //使用快慢指针遍历数组，指针指向不同值时修改慢指针值，快指针遍历完结束，return慢指针+1
        if (nums.size()==0) return 0;
        int i = 0,j = 0;
            for (j;j<nums.size();j++){
                if(nums[i]!=nums[j]){
                    //nums[++i]=nums[j];
                    i++;
                    nums[i]=nums[j];
                }

            }
            return i+1;
    }