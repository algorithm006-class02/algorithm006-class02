/*
 * @lc app=leetcode.cn id=127 lang=javascript
 *
 * [127] 单词接龙
 */

// @lc code=start
/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
    if(!endWord || wordList.indexOf(endWord) == -1){
        return 0;
    }
	// 各个通用状态对应所有单词
	let comboDicts = {};
	let len = beginWord.length;
    for(let i = 0;i<wordList.length;i++){
		for(let r = 0;r<len;r++){
			let newWord = wordList[i].substring(0,r)+'*'+wordList[i].substring(r+1,len);
			(!comboDicts[newWord]) && (comboDicts[newWord] = []);
			comboDicts[newWord].push(wordList[i]);
		}
	}
	// Queue for BFS
	let queue = [[beginWord,1]];
	// visited
	let visited = {beginWord:true};
	while(queue.length > 0){
		let currNode = queue.shift();
		let currWord = currNode[0];
		let currLevel = currNode[1];
		for(let i = 0;i < len;i++){
            // 通用状态
			let newWord = currWord.substring(0,i)+'*'+currWord.substring(i+1,len);
            if(newWord in comboDicts){
                let tmpWords = comboDicts[newWord];
                for(let z = 0;z<tmpWords.length;z++){
                    if(tmpWords[z] == endWord){
                        return currLevel + 1;
                    }
                    if(!visited[tmpWords[z]]){
                        visited[tmpWords[z]] = true;
                        queue.push([tmpWords[z],currLevel+1]);
                    }
                }
            }
		}
	}
	return 0;

};
// @lc code=end

