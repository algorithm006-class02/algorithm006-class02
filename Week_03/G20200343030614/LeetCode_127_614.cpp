//BFS，单词的每个字母从字母表中选择替换，如果在字典里就计入队列，记下步数
class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> candidate(wordList.begin(), wordList.end());
        queue<pair<string, int>> Q;
        Q.push({beginWord, 1});
        string words;
        int step;
        while (!Q.empty()) {
            if (Q.front().first==endWord) {
                return Q.front().second;
            }
            words = Q.front().first;
            step = Q.front().second;
            Q.pop();
            for (int i=0; i<words.length(); i++) {
                char tmp=words[i];
                for (char base : "abcdefghijklmnopqrstuvwxyz") {
                    if (words[i]==base) continue;
                    words[i]=base;
                    if (candidate.find(words)!=candidate.end()) {
                        Q.push({words, step+1});
                        candidate.erase(words);
                    }
                }
                words[i]=tmp;
            }
        }
        return 0;
    }
};