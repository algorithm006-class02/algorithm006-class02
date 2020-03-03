//暴力法 遍历每一个元素利用242题判断是否是异位词
//复杂度O3 直接超时
class Solution {
public:
	std::vector<std::vector<std::string>> groupAnagrams(std::vector<std::string>& strs) {
		std::vector<std::vector<std::string>> ret;
		int len = strs.size();
		if (len == 0) return ret;
		std::vector<bool> record;
		record.resize(len,false);
		for (int i = 0; i < len;i++){
			if (record[i]) continue;
			std::vector<std::string> cache;
			cache.push_back(strs[i]);
			for (int j = i+1; j < len; j++){
				if (isAnagram(strs[i], strs[j])){
					record[j] = true;
					cache.push_back(strs[j]);
				}
			}
			ret.push_back(cache);
		}
		return ret;
	}
    private:
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
//给字母排序作为hash的key值
class Solution {
public:
	std::vector<std::vector<std::string>> groupAnagrams(std::vector<std::string>& strs) {
        int  i;
        map<string,vector<string>>m;
        for(i=0;i<strs.size();i++)
        {
            string p=strs[i];
            sort(p.begin(),p.end());
            m[p].push_back(strs[i]);
            
        }
        vector<vector<string>>ans;
        map<string,vector<string>>::iterator it;
        for(it=m.begin();it!=m.end();it++)
        {
            ans.push_back(it->second);
        }
        return ans;
	}
};
//对上面的sort进行优化把生成key的过程变成一个常量 通常是申请一个26字节的数组(优化hash函数，由sort变为o1)
