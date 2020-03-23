#include <vector>
#include <string>
#include <unordered_set>

using namespace std;
//双BFS
int minMutation(string start, string end, vector<string>& bank) {
        if(start == end || bank.empty())
            return -1;
        unordered_set<string> candidate(bank.begin(),bank.end());
        if(candidate.find(end)== candidate.end())
            return -1;
        int step = 0;
        int wordlen = start.size();//每个单词的长度相同
        unordered_set<string> front,back,*pfront,*pback;
        front.insert(start);
        back.insert(end);
        while(!front.empty() && !back.empty()){
            if(front.size()<= back.size()){
                pfront = &front;
                pback = &back;
            }
            else{
                pfront = &back;
                pback = &front;
            }
            step++;
            unordered_set<string> next_front;
            for(auto iter = pfront->begin();iter!=pfront->end();iter++){
                for(int i=0;i<wordlen;i++){
                    string word = *iter;
                    for(auto c:"ACGT"){
                        if(word[i] == c) continue;
                            word[i] = c;
                        if(pback->find(word)!=pback->end()){
                            return step;
                        }
                        if(candidate.find(word)!=candidate.end()){
                            next_front.insert(word);
                            candidate.erase(word);
                        }
                    } 
                }

            }
            *pfront = next_front;
        }
        return -1;
    }