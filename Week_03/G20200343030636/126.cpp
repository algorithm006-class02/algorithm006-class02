#include <iostream>                                                                                                                                                         
#include <typeinfo>
#include <map>
#include <unordered_map>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

/*
 * @lc app=leetcode.cn id=126 lang=cpp
 *
 * [126] 单词接龙 II
 *
 * https://leetcode-cn.com/problems/word-ladder-ii/description/
 *
 * algorithms
 * Hard (31.99%)
 * Likes:    115
 * Dislikes: 0
 * Total Accepted:    6.6K
 * Total Submissions: 20.7K
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
		unordered_map<string,bool> flag;

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

	/*
	 * beginWord = "hit",
	 * endWord = "cog",
	 * wordList = ["hot","dot","dog","lot","log","cog"]

	 */
	void step(string &beginWord, string &endWord ,vector<string> &next,vector<string>& wordList) {
		for(int j = 0 ; j < wordList.size();++j) {

			//if(wordList[j].empty() || (flag.find(wordList[j]) != flag.end() && true == flag[wordList[j]]) ) continue ;
			if(wordList[j].empty() ) continue ;

			string one = wordList[j] ;

			if ( oneChange(one,beginWord) ) {

				next.emplace_back(one) ;
				wordList[j].clear()  ;

				if(one != endWord ) {
					if ( result.empty() || next.size() < result.back().size()) {
						step(one,endWord,next,wordList);
						//该路径已经走过了
						flag[one] = true ;
					}
				}
				else {
					if(result.empty() || result.back().size() == next.size() ){
						result.emplace_back(next);
					}
					else  if(next.size() < result.back().size()) {
						result.clear();
						result.emplace_back(next);
					}
				}
				next.pop_back();
				wordList[j] = one ;
			}
		}
	}


};

/*
   int main(char *argv[],int argc) {
   Solution a;
   string beginWord = "hit", endWord = "cog";
   vector<string> v = {"hot","dot","dog","lot","log","cog"};

   vector<vector<string>> r = a.findLadders(beginWord,endWord,v);
   for(auto ones : r ) {
   for(auto one : ones) {
   cout << one << " " ;
   }
   cout << endl ;
   }
   }
 */
// @lc code=end
