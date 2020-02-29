//127
//https://leetcode-cn.com/problems/word-ladder

class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        int wordSize = beginWord.length();
        unordered_map<string, vector<string>> comDict;
        unordered_map<string, bool> visited;
        for (string word : wordList) {
            for (int i = 0; i < wordSize; i++) {
                string comWord = word.substr(0, i) + '*' + word.substr(i + 1, wordSize);
                comDict[comWord].push_back(word);
            }
            visited[word] = false;
        }
        queue<pair<string, int>> qWords;
        qWords.push(make_pair(beginWord, 1));
        visited[beginWord] = true;
        while (!qWords.empty()) {
            pair<string, int> node = qWords.front();
            qWords.pop();
            string word = node.first;
            int level = node.second;
            for (int i = 0; i < wordSize; i++) {
                string comWord = word.substr(0, i) + '*' + word.substr(i + 1, wordSize);
                for (string adWord : comDict[comWord]) {
                    if (adWord == endWord)
                        return level + 1;
                    if (!visited[adWord]) {
                        visited[adWord] = true;
                        qWords.push(make_pair(adWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }
};
