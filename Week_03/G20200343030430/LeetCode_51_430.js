/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function (n) {
  if (n < 1) return []
  let cols = []
  let pie = []
  let na = []
  let res = []
  search(0, [], n, cols, pie, na, res)
  return res
};

function search (row, cur, n, cols, pie, na, res) {
  if (row >= n) {
    res.push(cur.slice())
    return
  }
  for (let col = 0; col < n; col++) {
    if (cols.includes(col) || pie.includes(row + col) || na.includes(row - col)) {
      continue
    }

    let str = print(col, n)
    cols.push(col)
    pie.push(row + col)
    na.push(row - col)
    cur.push(str)

    search(row + 1, cur, n, cols, pie, na, res)

    cur.pop(str)
    cols.pop(col)
    pie.pop(row + col)
    na.pop(row - col)
  }
}

function print (col, n) {
  let str = new Array(n).fill('.')
  str[col] = 'Q'
  return str.join('')
}