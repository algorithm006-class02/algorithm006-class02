/*
 * @lc app=leetcode.cn id=126 lang=cpp
 *
 * [126] 单词接龙 II
 *
 * https://leetcode-cn.com/problems/word-ladder-ii/description/
 *
 * algorithms
 * Hard (31.20%)
 * Likes:    115
 * Dislikes: 0
 * Total Accepted:    6.7K
 * Total Submissions: 20.9K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord
 * 的最短转换序列。转换需遵循如下规则：
 * 
 * 
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 
 * 
 * 说明:
 * 
 * 
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * 输出:
 * [
 * ⁠ ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * 输出: []
 * 
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 * 
 */

// @lc code=start
class Solution {
    vector<vector<string>> result ;
    unordered_map<string,int> done;

public:
    
	bool oneChange(string & a , string & b) {
		int num = 0 ;
		int i = 0 ;
		while(i <b.size()) {
			num += b[i] ==a [i] ? 0 : 1;

			if(num > 1) return false ;

			++i;
		}

		return num == 1;

	}


    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {


		if(wordList.size() <= 0 || beginWord.size() != endWord.size() || beginWord == endWord) return result ;


		if ( find ( wordList.begin(),wordList.end(),endWord ) == wordList.end()) {
			return result;
		}
		
		vector<string> next ;
		next.push_back(beginWord);
		step(beginWord,endWord,next,wordList);

		return result;

	}

	
	void step(string &beginWord, string &endWord ,vector<string> &next,vector<string>& wordList) {
		for(int j = 0 ; j < wordList.size();++j) {

			if(wordList[j].empty() ) continue ;

			string one = wordList[j] ;

			if ( oneChange(one,beginWord) ) {

				next.emplace_back(one) ;
				wordList[j].clear()  ;

				if(one != endWord ) {
					if ( result.empty() || next.size() < result.back().size()) {
						step(one,endWord,next,wordList);
					}
				}
				else {
                    //路径长度一样
					if(result.empty() || result.back().size() == next.size() ){
						result.emplace_back(next);
					}
                    //路径更短
					else  if(next.size() < result.back().size()) {
						result.clear();
						result.emplace_back(next);
					}
                    //路径计入备忘录，用于后面剪枝
                    for(auto str : next ) {
                        done[str] = next.size();
                    }

				}
				next.pop_back();
				wordList[j] = one ;
			}
		}
	}







   /*
   解法二：1.BFS，找到当前所有能转换的词
   2.判定是否是终点词，不是判断长度
   3.寻找下一个能转换的词
   */
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {


            if(wordList.size() <= 0 || beginWord.size() != endWord.size() || beginWord == endWord) return result ;


            if ( find ( wordList.begin(),wordList.end(),endWord ) == wordList.end()) {
                return result;
            }

            if(beginWord == endWord) {
                vector<string> one({beginWord});
                result.push_back(one) ; 
                return result;
            }

            unordered_set<string> words(wordList.begin(),wordList.end());

            queue<vector<string>> q;

            q.push({beginWord});
            

            while(!q.empty()) {

                int count = q.size();
                while(count > 0) {
                    vector<string> now = q.front();
                    for(auto str : now) cout << str << " ";
                    cout << endl;
                    q.pop();
                    //if(!result.empty() && now.size()>= result.back().size()) continue ;
                    if(done.find(now.back()) != done.end() && done[now.back()] < now.size() ) continue;
                    vector<string> onediff;
                    possibleStr(now,onediff,words) ;

                    for(auto & one : onediff) {
                        //找到
                        if ( one == endWord ) {
                            now.push_back(one) ;
                            if(result.empty() || now.size() == result.back().size())
                            {
                                result.emplace_back(now) ;
                            }
                            else if(now.size() < result.back().size()) {
                                result.clear();
                                result.emplace_back(now) ;
                            }
                        }
                        else {
                            
                            now.push_back(one);
                            done[one] = now.size();
                            q.push(now) ;
                            now.pop_back();
                        }
                    }
                
                    count -- ;
                }

            }
            return result ;
    }




   void possibleStr(vector<string> &now  ,vector<string> &onediff, unordered_set<string>& wordList) {
       string beginWord = now.back();
       for(int i = 0 ; i < beginWord.size() ; ++ i) {
           for(char a = 'a' ; a <= 'z' ; ++ a) {
               if ( beginWord[i] == a ) continue ;
               char tmp = beginWord[i] ;
               beginWord[i] = a ;
               if (wordList.find(beginWord) != wordList.end() && find(now.begin(),now.end(),beginWord) == now.end()) {
                   onediff.emplace_back(beginWord) ;
               }
               beginWord[i] = tmp ;
           }
       }
   }




};
// @lc code=end

