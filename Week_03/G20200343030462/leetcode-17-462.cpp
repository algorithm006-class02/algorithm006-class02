class Solution {
public:
    vector<string> letterCombinations(string digits) {
        if(digits.empty())
            return {};
        std::string strRet;
        std::vector<std::string> vecRet;
        std::unordered_map<char,std::string> unmapLetter;
        unmapLetter['2'] = "abc";
        unmapLetter['3'] = "def";
        unmapLetter['4'] = "ghi";
        unmapLetter['5'] = "jkl";
        unmapLetter['6'] = "mno";
        unmapLetter['7'] = "pqrs";
        unmapLetter['8'] = "tuv";
        unmapLetter['9'] = "wxyz";
        letterCombinations(digits,unmapLetter,0,"",vecRet);
        return vecRet;
    }
private:
    void letterCombinations(const std::string &strDigits, std::unordered_map<char,std::string> &unmapLetter,int iLevel,std::string strRet,std::vector<std::string> &vecRet)
    {
        if(iLevel == strDigits.size())
        {
            vecRet.push_back(strRet);
            return;
        }
        
        std::string strLetterOfNumber = unmapLetter[strDigits.at(iLevel)];
        for(int i = 0; i < strLetterOfNumber.size(); ++i)
        {
            letterCombinations(strDigits,unmapLetter,iLevel+1,strRet + strLetterOfNumber[i],vecRet);
        }
    }
};
