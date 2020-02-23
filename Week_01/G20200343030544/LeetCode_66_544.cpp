//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//
//最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
//你可以假设除了整数 0 之外，这个整数不会以零开头。
//
//示例 1:
//
//输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
//示例 2:
//
//输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/plus-one
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//


//暴力法求解 10分钟内没完成 直接看答案
class Solution {
	public:
	std::vector<int> plusOne(std::vector<int>& digits) {
		std::size_t len = digits.size();
		if (len == 0) return digits;
		std::size_t value = 0;
		bool up = false;
		std::size_t i = len - 1;
		value = digits[i] + 1;
		if (value == 10){
			up = true;
			digits[i] = 0;
			i--;
		}
		else{
			digits[i] = value;
			up = false;
		}
		for (; i != 0;i--){
			if (up){
				value = digits[i] + 1;
				if (value == 10){
					up = true;
					digits[i] = 0;
				}
				else{
					digits[i] = value;
					up = false;
					break;
				}
			}
			else {
				up = false; 
				break;
			};

		}
		if (up){
			std::vector<int> newdigits;
			newdigits.resize(len + 1);
			memcpy(&newdigits[1],&digits[0],len*sizeof(int));
			newdigits[0] = 1;
			digits = newdigits;
		}
		return digits;
	}

};
//直接看答案，发现没有考虑到元素不为9时直接退出这个逻辑，导致上面写的很复杂，先背过再说
class Solution {
public:
	std::vector<int> plusOne0(std::vector<int>& digits){
		std::size_t len = digits.size();
		for (int i = len - 1; i >= 0; i--){
			digits[i]++;
			digits[i] %= 10;
			if (digits[i] != 0) return digits;
		}
		digits.insert(digits.begin(), 1);
		return digits;
	}
};
