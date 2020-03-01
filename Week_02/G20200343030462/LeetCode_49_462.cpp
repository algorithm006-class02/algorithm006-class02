class Solution {
public:
    //本题的意思就是对异位词进行分组
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        std::unordered_map<std::string,std::vector<std::string>>   m_hashmapAnagramsSet;      //key是经过排序后的string，value是所有和key为异位词的字符串
        for(const auto &str : strs )
        {
            std::string strTmp = str;          //这里给个临时变量是因为sort排序会改变源字符串的值
            std::sort(strTmp.begin(),strTmp.end());
            m_hashmapAnagramsSet[strTmp].push_back(str);
        }
        
        std::vector<std::vector<std::string>> vecRet;
        for(const auto &value : m_hashmapAnagramsSet)
        {
            vecRet.push_back(value.second);
        }
        return  vecRet;      
    }
};
