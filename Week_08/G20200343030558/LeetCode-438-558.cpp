#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>

using namespace std;

//暴力求解，超时了
vector<int> findAnagrams(string s, string p) {
        if(s.length() == 0 || p.length() == 0 || s.length()<p.length())
            return {};
        vector<int> res;
        int len = p.length();
        for(int i = 0;i<=s.length()-len;i++){
            string temp = s.substr(i,len);
            sort(temp.begin(),temp.end());
            sort(p.begin(),p.end());
            if(temp == p){
                res.push_back(i);
            }
        }
        return res;
    }


//滑动窗口的做法，参考别人的
vector<int> findAnagrams(string s, string p) {
        if(s.length() == 0 || p.length() == 0 || s.length()<p.length())
            return {};
        vector<int> res;
        int left = 0, right = 0;
        unordered_map<char, int> needs;
        unordered_map<char, int> window;
        for (char c : p) needs[c]++;
        int match = 0;
    
        while (right < s.size()) {
            char c1 = s[right];
            if (needs.count(c1)) {
                window[c1]++;
                if (window[c1] == needs[c1])
                    match++;
            }
            right++;

            while (match == needs.size()) {//包含所有字符
                if (right - left == p.size()) {
                    res.push_back(left);
                }
                char c2 = s[left];
                if (needs.count(c2)) {
                    window[c2]--;
                    if (window[c2] < needs[c2])
                        match--;
                }
                left++;
            }
        }
        return res;
    }