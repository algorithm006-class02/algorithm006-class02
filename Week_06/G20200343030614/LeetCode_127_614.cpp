//双向BFS解单词接龙问题
class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_map<string,int> freqs;
		for (const auto &word:wordList)
			freqs[word]=0;
		if (freqs.count(endWord)==0) return 0;
		queue<string> q1({beginWord}), q2({endWord});
		int step=1;
		for (freqs[beginWord]|=1,freqs[endWord]|=2; q1.size() && q2.size(); ++step) {
			bool first=q1.size()<q2.size();
			queue<string> &q=first?q1:q2;
			int flag=first?1:2;
			for (int size=q.size(); size--; q.pop()) {
				string &word=q.front();
				if (freqs[word]==3) return step;
				for (int i=0; i<word.length(); ++i) {
					for (char ch='a'; ch<='z'; ++ch) {
						string s=word;
						if (s[i]==ch) continue;
						s[i]=ch;
						if (freqs.count(s)==0 || freqs[s]&flag) continue;
						freqs[s]|=flag;
						q.push(s);
					}
				}
			}
		}
		return 0;
    }
};