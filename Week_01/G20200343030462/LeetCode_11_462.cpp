//时间复杂度是O(n)
//空间复杂度是O(n)
#include <vector>
#include <unordered_map>
class CTwoSum {
public:
    std::vector<int> twoSum(std::vector<int>& nums, int target) {
        if( nums.size() < 2 )
            return {};
        std::unordered_map<int,int> hashSearchingTable;     //key为数组元素，value为该数组元素对应的下标
        std::vector<int> vecRet;
        for(int iIndex = 0; iIndex < nums.size(); ++iIndex)
        {
            int iAugend = target - nums[iIndex];
            if(hashSearchingTable.end() != hashSearchingTable.find(iAugend))
            {
                vecRet.push_back(hashSearchingTable[iAugend]);      //注意顺序，hashSearchingTable搜索表里保存的数据相对于iIndex来说是历史数据
                vecRet.push_back(iIndex);
                break;
            }
            hashSearchingTable[nums[iIndex]] = iIndex;
        }
        return vecRet;
    }
};

