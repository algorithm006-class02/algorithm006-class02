//暴力法做的自己都不认识了，直接看答案
class Solution {
public:
	//客户的钱-5 ,储蓄里如果有这么多 
	bool judgeCurrent(int bill){
		//判断储蓄
		if (bill == 5) {
			store.push_back(bill);
			return true; 
		}
		else{
			int charge = bill - 5;
			//bill-5在store的总和之一
			int total = 0;
			for (int i = 0; i < store.size();i++){
				total += store[i];
				if (total){}
			}
			return false;
		}
		
		//更新储蓄

	}

	bool lemonadeChange(std::vector<int>& bills) {
		std::size_t len = bills.size();
		for (int i = 0; i < len;i++){
			
			if (!judgeCurrent(bills[i])) return false;

			store.push_back(bills[i]);
		}
		return true;
	}

	std::vector<int> store;
};
//这个逻辑确实简单，看完直接写出来了，这应该才是暴力法吧
class Solution {
public:
	bool lemonadeChange(std::vector<int>& bills) {
		int five = 0;
		int ten = 0;
		std::size_t len = bills.size();
		for (int i = 0; i < len;i++){
			if (bills[i] == 5){
				five++;
			}
			else if (bills[i] == 10){
				if (five > 0){
					five--;
					ten++;
				}
				else{
					return false;
				}
			}
			else{
				//这里是20 ,需要15块
				if (five > 0 && ten > 0){
					five--;
					ten--;
				}
				else if (five >= 3){
					five -= 3;
				}
				else { return false; }
			}
		}
		return true;
	}
};
