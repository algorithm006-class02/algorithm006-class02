//暴力解法 用一个set 解答错误 "ab" "a"的情况没有考虑，解决方法：加上长度判断
//解答错误 "aacc" "ccac"的情况没考虑，原因是没理解字母异位词,解决方法：把set换成map map<元素值，出现的次数> t中找到元素值并且次数相等才返回true
//15分钟暴力法解决
//超哥解释：异位词的解释： 英文Anagram 字母出现次数一样，但顺序不一样
//超哥4件套：
  //1,clarification 和面试官把题目过一遍
  //2, possible solutions --optimal(time & space) 选最优的写
  // 1>暴力法 sort一遍 这个没想到 因为是学哈希 
  // 2> hash统计每个字符的频次 出现频次一样就true(或放到长度256的数组计数)思路和我一样
  // 3, code
  // 4,test case
//养成收藏精选代码的习惯
class Solution {
public:
	bool isAnagram(std::string s, std::string t) {
		if (s.length() != t.length()) return false;
		std::map<char,int> sMap;
		for (auto& a : s){
			auto&& iter = sMap.find(a);
			if (iter != sMap.end()) iter->second++;
			else sMap.insert(std::make_pair(a,1));
		}
		std::map<char, int> tMap;
		for (auto& a : t){
			auto&& iter = tMap.find(a);
			if (iter != tMap.end()) iter->second++;
			else tMap.insert(std::make_pair(a, 1));
		}
		if (sMap == tMap) return true;
		else return false;
	}
};
//暴力法
class Solution {
public:
	bool isAnagram(std::string s, std::string t) {
		if (s.length() != t.length()) return false;
		std::sort(s.begin(),s.end());
		std::sort(t.begin(), t.end());
		return s == t;
	}
};

//26长度的数组hash
class Solution {
public:
	bool isAnagram(std::string s, std::string t) {
		if (s.length() != t.length()) return false;
		const char base = 'a';
		int counter[26] = {0};
		for (auto&a : s){
			counter[a - base]++;
		}
		for (auto&a : t){
			counter[a - base]--;
		}
		for (int i = 0; i < 26; i++){
			if (counter[i] != 0) return false;
		}
		return true;
	}
};

//小于0直接return false固然没错 但是否有漏掉的情况，怎么解释
class Solution {
public:
	bool isAnagram(std::string s, std::string t) {
		if (s.length() != t.length()) return false;
		const char base = 'a';
		int counter[26] = { 0 };
		for (auto&a : s){
			counter[a - base]++;
		}
		for (auto&a : t){
			counter[a - base]--;
			if (counter[a - base] < 0) return false;
		}
		return true;
	}
};
