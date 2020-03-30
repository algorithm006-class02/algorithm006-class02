/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function (intervals) {
  intervals.sort((a, b) => a[0] - b[0])
  const res = []
  for (let arr of intervals) {
    if (!res.length || res[res.length - 1][1] < arr[0]) {
      res.push(arr)
    } else {
      res[res.length - 1][1] = Math.max(res[res.length - 1][1], arr[1])
    }
  }
  return res
};