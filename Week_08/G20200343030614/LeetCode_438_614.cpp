class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        if (s.size()<p.size()) return {};
        vector<int> res;
        int n = p.size();
        unordered_map<char, int> ch;
        for (int i=0; i<n; i++) {
            ch[p[i]]++;
        }
        unordered_map<char, int> chs;
        for (int i=0; i<s.size()-n+1; i++) {
            string tmp = s.substr(i, n);
            for (int j=0; j<n; j++) {
                chs[tmp[j]]++;
            }
            int k=0;
            for (k=0; k<n; k++) {
                if (chs[tmp[k]]!=ch[tmp[k]]) break;
            }
            if (k==n)
                res.push_back(i);
            for (int j=0; j<n; j++) {
                chs[tmp[j]]--;
            }
        }
        return res;
    }
};

class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
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

            while (match == needs.size()) {
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
};