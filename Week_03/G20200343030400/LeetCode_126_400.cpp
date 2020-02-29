//126
//https://leetcode-cn.com/problems/word-ladder-ii

class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        vector<vector<string>> res = {};
        int wordSize = beginWord.length();
        unordered_map<string, vector<string>> comDict;
        unordered_map<string, int> visited;
        for (string word : wordList) {
            for (int i = 0; i < wordSize; i++) {
                string comWord = word.substr(0, i) + '*' + word.substr(i + 1, wordSize);
                comDict[comWord].push_back(word);
            }
            visited[word] = INT_MAX;
        }
        visited[beginWord] = 1;
        if (visited.find(endWord) == visited.end())
            return res;
        int level = 1;
        bool found = false;
        queue<pair<string, vector<string>>> qWords;
        vector<string> begintrack = {beginWord};
        qWords.push(make_pair(beginWord, begintrack));
        while (!qWords.empty() && !found) {
            int queueSize = qWords.size();
            for (int k = 0; k < queueSize; k++) {
                string word = qWords.front().first;
                vector<string> track = qWords.front().second;
                qWords.pop();
                for (int i = 0; i < wordSize; i++) {
                    string comWord = word.substr(0, i) + '*' + word.substr(i + 1, wordSize);
                    for (string newWord : comDict[comWord]) {
                        if (newWord == endWord) {
                            found = true;
                            track.push_back(newWord);
                            res.push_back(track);
                            track.pop_back();
                        }
                        if (visited.find(newWord) != visited.end() && visited[newWord] > level) {
                            track.push_back(newWord);
                            visited[newWord] = level + 1;
                            qWords.push(make_pair(newWord, track));
                            track.pop_back();
                        }
                    }
                }
            }
            level++;
        }
        return res;
    }
};
