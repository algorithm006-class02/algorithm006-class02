/**
 * 127. Word Ladder
 * https://leetcode.com/problems/word-ladder/
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
/** BFS 
 * 循环比较 beginWord 与 wordList 中的字符，把相差1个字符的字符放入 queue，等待循环比较
 * 每成功找到1个字符，transNumber + 1
 * 如果 beginWord 与 endWord 相等，则返回 transNumber
 */
const ladderLength = (beginWord, endWord, wordList) => {
  let wordSet = new Set(wordList)    
  if (!wordSet.has(endWord)) return 0
  let queue = [[beginWord, 1]]
  while (queue.length) {
    let [word, transNumber] = queue.pop()  
    if (word === endWord) return transNumber
    for (let str of wordSet) {
      if (charDiff(word, str) === 1) {
        queue.unshift([str, transNumber+1])  
        wordSet.delete(str)
      }
    }
  }
  return 0
};

const charDiff = (str1, str2) => {
  let changes = 0
  for (let i = 0; i < str1.length; i++) {
    if (str1[i] != str2[i]) changes += 1
  }
  return changes
}