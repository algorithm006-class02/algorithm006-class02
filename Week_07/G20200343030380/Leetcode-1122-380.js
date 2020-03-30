/**
 * 1122. Relative Sort Array
 * https://leetcode-cn.com/problems/relative-sort-array/
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
// 解法一：Array.sort()
const relativeSortArray = (arr1, arr2) => {
  arr1.sort((a, b) => {
    let aIndex = arr2.indexOf(a), bIndex = arr2.indexOf(b)
    if (aIndex === -1 && bIndex === -1) return a - b
    if (aIndex === -1) return 1
    if (bIndex === -1) return -1
    return aIndex - bIndex
  })
  return arr1
}

// 解法二：计数排序
const relativeSortArray = (arr1, arr2) => {
  let result = [], countArray = new Array(1001)
  arr1.forEach(num => { countArray[num] = countArray[num] ? countArray[num] + 1 : 1 })
  arr2.forEach(num => {
    while(countArray[num]) {
      result.push(num)
      countArray[num]--
    }
  })
  for (let i = 0; i < countArray.length; ++i) {
    while (countArray[i] >= 1) { result.push(i); countArray[i]-- }
  }
  return result
}