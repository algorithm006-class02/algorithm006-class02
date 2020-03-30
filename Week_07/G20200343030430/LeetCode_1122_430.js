/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function (arr1, arr2) {
  let p = 0
  for (let i = 0; i < arr2.length; i++) {
    let n = arr2[i]
    for (let j = p; j < arr1.length; j++) {
      if (arr1[j] == n) {
        let t = arr1[p]
        arr1[p] = arr1[j]
        arr1[j] = t
        p++
      }
    }
  }
  let list = arr1.slice(p).sort((a, b) => a - b)
  for (let i = p; i < arr1.length; i++) {
    arr1[i] = list[i - p]
  }
  return arr1
};