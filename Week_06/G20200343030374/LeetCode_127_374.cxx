// https://leetcode-cn.com/problems/word-ladder/
#include <string>
#include <vector>
#include <unordered_set> 
#include <queue>

using namespace std;

// use queue
class Solution_1 {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
      unordered_set<string> dicts(wordList.begin(), wordList.end());
      if (dicts.find(endWord) == dicts.end()) return 0;
      queue<string> q;
      q.push(beginWord);
      unordered_set<string> visited{beginWord};
      int len = beginWord.size();
      int cnt = 1;
      while (!q.empty())
      {
        int n = q.size();
        for (int i = 0; i < n; ++i) {
          string word = q.front();
          q.pop();
          for (int j = 0; j < len; ++j) {
            char c = word[j];
            for (int k = 0; k < 26; ++k) {
              word[j] = 'a' + k;
              if (word == endWord) return cnt + 1;
              if (dicts.find(word) != dicts.end() && visited.find(word) == visited.end()) {
                q.push(word);
                visited.insert(word);
              }
            }
            word[j] = c;
          }
        }
        cnt++;
      }
      return 0;
    }
};

// use set
class Solution_2 {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
      unordered_set<string> dicts(wordList.begin(), wordList.end()), q;
      if (dicts.find(endWord) == dicts.end()) return 0;
      q.insert(beginWord);
      int cnt = 1;
      while (!q.empty()) {
        unordered_set<string> temp;
        for (auto it = q.begin(); it != q.end(); ++it) {
          string word = *it;
          for (int i = 0; i < word.size(); ++i) {
            char t = word[i];
            for (int j = 0; j < 26; ++j) {
              word[i] = 'a' + j;
              if (word == endWord) return cnt + 1;
              if (dicts.find(word) != dicts.end()) {
                temp.insert(word);
                dicts.erase(word);
              }
            }
            word[i] = t;
          }
        }
        cnt++;
        q.swap(temp);
      }
      return 0;
    }
};

// two-end bfs
class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
      unordered_set<string> dicts(wordList.begin(), wordList.end()), head, tail, *phead, *ptail;
      if (dicts.find(endWord) == dicts.end()) return 0;
      head.insert(beginWord);
      tail.insert(endWord);
      phead = &head;
      ptail = &tail;
      int cnt = 2;
      while (!head.empty() && !tail.empty()) {
        unordered_set<string> temp;
        for (auto it = phead->begin(); it != ptail->end(); ++it) {
          string word = *it;
          for (int i = 0; i < word.size(); ++i) {
            char t = word[i];
            for (int j = 0; j < 26; ++j) {
              word[i] = 'a' + j;
              if (ptail->find(word) != ptail->end()) return cnt;
              if (dicts.find(word) != dicts.end()) {
                dicts.erase(word);
                temp.insert(word);
              }
            }
            word[i] = t;
          }
        }
        cnt++;
        phead->swap(temp);
        if (head.size() < tail.size()) {
          phead = &head;
          ptail = &tail;
        } else {
          phead = &tail;
          ptail = &head;
        }
      }
      return 0;
    }
};