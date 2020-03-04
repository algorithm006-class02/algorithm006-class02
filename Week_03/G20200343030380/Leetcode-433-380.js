/**
 * 433. Minimum Genetic Mutation
 * https://leetcode.com/problems/minimum-genetic-mutation/
 * @param {string} start
 * @param {string} end
 * @param {string[]} bank
 * @return {number}
 */
/*
 * 方法一：使用队列实现BFS
 * 思路：通过循环变换一个字符，使 start 转换成 bank 中存在的值, 并存入 queue 队列中，mutationsNumber + 1
 * 递归判断该值是否为 end, 如果找到，返回 mutationsNumber
 * 否则返回 -1
 */
const minMutation = (start, end, bank) => {
  let bankSet = new Set(bank)
  if (!bankSet.has(end)) return -1
  let queue = [[start, 0]]
  const DNA = ['A', 'C', 'G', 'T']
  while (queue.length > 0) {
    let [gene, mutationsNumber] = queue.pop()
    if (gene === end) return mutationsNumber
    for (let i = 0; i < gene.length; i++) {
      for (let c of DNA) {
        let newGene = gene.slice(0, i) + c + gene.slice(i+1)
        if (bankSet.has(newGene)) {
          queue.unshift([newGene, mutationsNumber+1])
          bankSet.delete(newGene)
        }
      }
    }
  }
  return -1
}

// 方法二：递归 (未AC)
// 从start开始，递归计算改变一个字符，能够组成的target，从 bank 中查询是否存在这些target
// 如果存在，继续递归计算改变一个字符，能够组成的target，直到找到 end
// 如果改变一个字符后的target不存在于bank中，则返回-1
//const minMutation = (start, end, bank) => {
//  if (!bank || !bank.includes(end)) return -1
//  let visited = []
//  return recursion(start, end, bank, 0, visited)  
//};
  
//const recursion = (start, end, bank, level, visited) => {
//  if (start === end) return level
//  let tempBank = []
//  let bankCopy = [...bank]
//  for (let target of bankCopy) {
//    if (start === target) continue
//    let changes = 0
//    for (let i = 0; i < target.length; i++) {
//      if (start[i] === target[i]) continue
//      changes += 1
//    }
//    if (!visited.includes(target) && changes === 1) { 
//      tempBank.push(target) 
//      visited.push(target)
//    }
//  }
//  if (tempBank.length > 0) {
//    for (let temp of tempBank) {
//      recursion(temp, end, bank, level+1, visited)
//    }
//  } 
//  return -1
//} 