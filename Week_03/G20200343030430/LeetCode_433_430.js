/**
 * @param {string} start
 * @param {string} end
 * @param {string[]} bank
 * @return {number}
 */
var minMutation = function (start, end, bank) {
  const map = bank.reduce((s, v) => {
    s[v] = 1
    return s
  }, {})
  const letters = ['A', 'C', 'G', 'T']
  const queue = [{ val: start, level: 0 }]
  while (queue.length) {
    let { val, level } = queue.shift()
    if (val === end) return level
    for (let i = 0; i < val.length; i++) {
      for (let c of letters) {
        if (val[i] !== c) {
          let key = val.substring(0, i) + c + val.substring(i + 1)
          if (map[key]) {
            map[key] = 0
            queue.push({ val: key, level: level + 1 })
          }
        }
      }
    }
  }
  return -1
};