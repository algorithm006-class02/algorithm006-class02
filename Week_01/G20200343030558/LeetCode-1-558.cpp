#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

vector<int> twoSum(vector<int>& nums,int target){
    unordered_map<int, int> tmpmap;
    for (int i = 0; i < nums.size();i++){
        int second = target - nums[i];
        if (tmpmap.find(second)!=tmpmap.end()){
            return vector<int>{tmpmap[second], i};
        }
        tmpmap[nums[i]] = i;
    }
    return vector<int>{};
}