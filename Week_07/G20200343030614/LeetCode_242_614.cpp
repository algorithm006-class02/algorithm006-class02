//排序方法
class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.size()!=t.size()) {
            return false;
        }
        sort(s.begin(),s.end());
        sort(t.begin(),t.end());
        return s==t;
    }
};

//统计字母
class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.size()!=t.size()) {
            return false;
        }
        int s_char[26]={0};
        int t_char[26]={0};
        for (int i=0; i<s.size(); i++) {
            s_char[s[i]-'a']++;
        }
        for (int i=0; i<s.size(); i++) {
            t_char[t[i]-'a']++;
        }
        for (int i=0; i<26; i++) {
            if (s_char[i]!=t_char[i]) {
                return false;
            }
        }
        return true;
    }
};

//哈希表法
class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.size()!=t.size()) {
            return false;
        }
        unordered_map<char,int> ch_map;
        for (int i=0; i<s.size(); i++) {
            ++ch_map[s[i]];
            --ch_map[t[i]];
        }
        for (auto ob : ch_map) {
            if (ob.second!=0) {
                return false;
            }
        }
        return true;
    }
};