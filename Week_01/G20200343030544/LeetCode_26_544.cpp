//这个题之前做过，注意和移除零那个题有想通的地方，和value比较后不等++后交换，注意返回时index要+1
class Solution {
public:
	int removeDuplicates(std::vector<int>& nums) {
		std::size_t len = nums.size();
        if (len == 0) return 0;
		int index = 0;
		int value = nums[0];
		for (int i = 0; i < len; i++){
		    if (value != nums[i]){
				index++;
				nums[index] = nums[i];
				value = nums[i];
			}
		}
		return index+1;
	}
};
