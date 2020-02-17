#include <iostream>
using namespace std;
class CThreeSumLoop {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        //暴力求解，既然是三数之和，那么自然是需要3个循环了，每一个循环选择代表一个数的遍历
        std::sort(nums.begin(),nums.end());				//目的是为了去重
        std::vector<std::vector<int>> vecRet;         //存储结果集
        std::vector<int> vecMidRet;         //用于存储中间结果集
        for(int i = 0; i < nums.size() -2; ++i)
        {
            for(int j = i + 1; j < nums.size() - 1; ++j)
            {
                for(int k = j + 1; k < nums.size(); ++k)
                {
                    int a,b,c;
                    a = nums[i];
                    b = nums[j];
                    c = nums[k];
                    if( (0 == a + b + c))
                    {
                        if(true == vecRet.empty())
                        {
                            //如果最终的结果集是空的，那就不需要去重
                            vecRet.push_back({a,b,c});
                        }
                        else
                        {
                            vecMidRet.push_back(a);
                            vecMidRet.push_back(b);
                            vecMidRet.push_back(c);		//一定要保证这个中间结果集是有序的，否则判断两个无序元组是否相等的辅助函数将会无法正常工作
                            if(false == equalVec(vecRet[vecRet.size() - 1],vecMidRet))
                            {
                                vecRet.push_back(vecMidRet);
                            }
                            vecMidRet.clear();
                        }
                   
                    }
                }
            }
        }
        return vecRet;
    }

private:
    //判断两个无序三元组（这里取离散数学里集合的概念）是否相等，思路是对两个vector先排序，然后再逐个比较，输入要确保两个参数是3元组，这里就不检查参数了
    bool equalVec(std::vector<int> &vecLeft,std::vector<int> &vecRight)
    {
        //std::sort(vecLeft.begin(),vecLeft.end());		//treeSum函数里排过序了，内层就不需要排序了，但是，你需要保证传进来的vecLeft和vecRight必须是严格有序的
        //std::sort(vecRight.begin(),vecRight.end());
        if(vecLeft[0] == vecRight[0] && vecLeft[1] == vecRight[1] && vecLeft[2] == vecRight[2])
        {
            return true;
        }
        return false;
    }
};

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        if(nums.size() < 3)
            return {};      //此时返回结果不应该有值，即使是一个空的vector
        std::vector<std::vector<int>> vecRet;
        //用双指针的解法求解，首先对数组进行排序，方便后面去重以及指针移动
        //双指针解法的话，就是固定三数中的一个，对其它两个数施以双指针的做法
        std::sort(nums.begin(),nums.end());
        for(int iLoop = 0;iLoop < nums.size(); ++iLoop)
        {
            //对第一个数去重
            if(iLoop > 0 && (nums[iLoop] == nums[iLoop - 1]))
               continue;
            int iLeft = iLoop + 1;
            int iRight = nums.size() - 1;
            while(iLeft < iRight)
            {
                //左侧的指针指向的数小了
                if(nums[iLeft] + nums[iRight] + nums[iLoop] < 0) 
                    ++iLeft;
                else if(nums[iLeft] + nums[iRight] + nums[iLoop] > 0)  //说明右侧的指针指向的数大了
                    --iRight;
                else
                {
                    vecRet.push_back({nums[iLoop],nums[iLeft],nums[iRight]});
                    //去重，思想是，三数之和一定，如果两个数是定值，另外一个数也必定是定值
                    while(iLeft < iRight && nums[iLeft] == nums[iLeft + 1])
                        ++iLeft;
                    while(iLeft < iRight && nums[iRight] == nums[iRight - 1])
                        --iRight;
                    //++iLeft和--iRight有个考虑：
                    //第一：在nums[iLeft] == nums[iLeft + 1]的情况下，我的while循环最多只能把iLeft跳到iLeft+1的位置上，此时索引iLeft位置上的值和初始的nums[iLeft]相同，这时要把iLeft跳到和初始nums[iLeft]不同的索引上，就要对iLeft进行自增；iRight是一样的考虑
                    //第二：如果nums[iLeft] != nums[iLeft + 1]，要把iLeft向前移动，确保算法能够正常执行而不会出现死循环，这是也要对iLeft进行自增，而iRight也是一样的考虑
                    ++iLeft;        
                    --iRight;
                }
            }
        }
        return vecRet;
    }
};
