/**
 * 621. Task Scheduler
 * https://leetcode.com/problems/task-scheduler/ 
 * @param {character[]} tasks
 * @param {number} n
 * @return {number}
 */
/** 贪心 + 排序
 * base case：如果任务冷却时间为0，或者只有一个任务时，直接返回任务列表长度即可
 * 1. 首先需要找到重复次数最高的任务, 并且我们不关心这个任务是'A'还是'B', 只要拿到次数就好
   2. 贪心原则：所需时间只和当前重复次数最高的任务有关 
      所以，数组降序排列, taskCount[0] 为重复性最高的任务的重复次数，依此类推
   3. 举例：tasks = ["A","A","A","B","B","B"], n = 2, idle = 表示空闲1个单位时间
      A -> idle -> idle -> A -> idle -> idel -> A
      在 n+1 个单位时间内，A 只可能执行一次，所以要执行完所有的A，所需的最短时间为 (taskCount[0] -1) * (n + 1) + 1
   4. 重复次数小于 taskCount[0] 的，都可以先塞进 idle 时间去执行，所以总时间不增加
      重复次数等于 taskCount[0] 的，还需要额外一次单位时间才能执行完成，所以 minTime++
   5. 如果没有重复的任务数量大于有重复的任务数量，且冷却时间 n < tasks.length, 则总时间应为: 任务列表长度
      否则应为 minTime
 */
const leastInterval = (tasks, n) => {
  if (n === 0 || tasks.length === 1) return tasks.length
  let taskCount = new Array(26).fill(0)
  for (let char of tasks) taskCount[char.charCodeAt()-'A'.charCodeAt()]++
  taskCount.sort((a,b) => b - a)
  let minTime = (taskCount[0] - 1) * (n + 1) + 1
  for (let i = 1; i < taskCount.length; i++) {
    if (taskCount[i] === 0) break
    if (taskCount[i] === taskCount[0]) minTime++
  }
  return Math.max(minTime, tasks.length) 
}