class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        if( nums.size() < 2 )
            return {};
        std::unordered_map<int,int> hashSearchingTable; //key是数组元素，value是索引
        std::vector<int> vecRet;
        for(int iIndex = 0; iIndex < nums.size(); ++iIndex)
        {
            int iAugend = target - nums[iIndex];
            if( hashSearchingTable.end() != hashSearchingTable.find(iAugend))
            {
                vecRet.push_back(hashSearchingTable[iAugend]);
                vecRet.push_back(iIndex);
                break;
            }
            hashSearchingTable[nums[iIndex]] = iIndex;
        }
        return vecRet;
    }
};
