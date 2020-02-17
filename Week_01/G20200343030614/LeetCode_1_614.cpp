//map a键值对，键值是元素，实值是元素下标
//a[2]=0

//i==1:
//a.count(9 - 7)
//=> a.count(2)
//此时，a.count(2)==1
//所以
//b[0]=a[9-7]=a[2]=0
//b[1]=1
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int,int> a;//提供一对一的hash
        vector<int> b(2,-1);//用来承载结果，初始化一个大小为2，值为-1的容器b
        for(int i=0;i<nums.size();i++) {
            if(a.count(target-nums[i])>0) {
                b[0]=a[target-nums[i]];
                b[1]=i;
                break;
            }
            a[nums[i]]=i;//反过来放入map中，用来获取结果下标
        }
        return b;
    }
};