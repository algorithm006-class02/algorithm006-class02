#include <vector>
#include <unordered_set>
#include <queue>

using namespace std;

 int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
     if(beginWord == endWord)
         return 0;
     unordered_set<string> candidate(wordList.begin(), wordList.end());
     queue<pair<string, int>> q;
     q.push({beginWord, 1});
     string word;
     int ladder;
     while(!q.empty()){
         if(q.front().first == endWord){
             return q.front().second;
         }
         word = q.front().first;
         ladder = q.front().second;
         q.pop();
         for (int i = 0; i < word.size();i++){
             char tmpc = word[i];
             for (char c = 'a'; c <= 'z';c++){
                 if(word[i] == c)
                     continue;
                 word[i] = c;
                 if(candidate.find(word)!=candidate.end()){
                     q.push({word, ladder + 1});
                     candidate.erase(word);
                 }
             }
             word[i] = tmpc;
         }
     }
     return 0;
 }

 