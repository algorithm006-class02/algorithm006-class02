const findLadders = (beginWord, endWord, wordList) => {
  let wordSet = new Set(wordList)
  if (!wordSet.has(endWord)) return []

  let queue = new Set([beginWord])
  let map = new Map(), distance = 0, minDistance = 0
  while (queue.length) {
    if (queue.has(endWord)) break
    let trySet = new Set()
    for (let word of queue) {
      let mapSet = new Set()
      for (let i = 0; i < word.length; i++) {
        for (let j = 0; j < 26; j++) {
          let tryWord = word.slice(0, i) + String.fromCharCode(97+j) + word.slice(i+1)
          if (!minDistance && tryWord === endWord) minDistance = distance + 1
          if (wordSet.has(tryWord)) {
            trySet.add(tryWord)
            mapSet.add(tryWord)
          }
        }
      }
      map.set(word, mapSet)
    }
    distance++
    for (let w of trySet) {
      wordSet.delete(w)
    }
    queue = trySet
  }
  let result = []
  let path = [beginWord]
  dfs(beginWord, endWord, result, paht, map, minDistance, 0)
  return result
}