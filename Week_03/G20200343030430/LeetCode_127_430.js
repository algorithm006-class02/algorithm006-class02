/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function (beginWord, endWord, wordList) {
  const L = beginWord.length
  // 构造通用匹配map
  const map = {}
  wordList.forEach(w => {
    for (let i = 0; i < L; i++) {
      let key = w.substring(0, i) + '*' + w.substring(i + 1)
      map[key] = map[key] || []
      map[key].push(w)
    }
  })
  const queue = [{ val: beginWord, level: 1 }]
  const visited = { [beginWord]: 1 }
  while (queue.length) {
    let { val, level } = queue.shift()
    for (let i = 0; i < L; i++) {
      let key = val.substring(0, i) + '*' + val.substring(i + 1)
      map[key] = map[key] || []
      for (let w of map[key]) {
        if (w === endWord) {
          return level + 1
        }
        if (!visited[w]) {
          visited[w] = 1
          queue.push({ val: w, level: level + 1 })
        }
      }
    }
  }
  return 0
};