/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function (nums) {
  let level = 0
  const res = []

  const search = (index, cur) => {
    if (level === cur.length) {
      res.push(cur.slice())
    }
    for (let i = index; i < nums.length; i++) {
      cur.push(nums[i])
      search(i + 1, cur)
      cur.pop()
    }
  }

  for (; level < nums.length + 1; level++) {
    search(0, [])
  }
  return res
};