/**
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/
 * @param {number} n
 * @return {number}
 */
// 方法一：数组遍历
//var climbStairs = function(n) {
//  if (n <= 2) return n
//  let fibo = [0, 1, 2]
//  for (let i = 3; i <= n; i++) {
//    fibo[i] = fibo[i-1] + fibo[i-2]  
//  }
//  return fibo[n]
//};

// 方法二：不用数组遍历
//const climbStairs = (n) => {
//  if (n <= 2) return n
//  let [f1, f2, f3] = [1, 2, 3]
//  for (let i = 3; i <= n; i++) {
//    f3 = f1 + f2
//    f1 = f2
//    f2 = f3
//  }
//  return f3
//}

// 方法三：递归
const climbStairs = (n, result = [0, 1, 2]) => {
  if (n <= 3) return n
  if (result[n] == undefined) {
    result[n] = climbStairs(n-1, result) + climbStairs(n-2, result)
  }
  return result[n]
}