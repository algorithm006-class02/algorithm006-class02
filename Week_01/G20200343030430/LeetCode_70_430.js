/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function (n) {
  if (n < 3) return n
  let f = 1
  let s = 2
  let sum = 3
  for (let i = 2; i < n; i++) {
    sum = f + s
    f = s
    s = sum
  }
  return sum
};

// 尾递归  fib(1, 2, n)
function fib (f, s, n) {
  if (n < 3) return n
  if (n == 3) return f + s
  return fib(s, f + s, n - 1)
}