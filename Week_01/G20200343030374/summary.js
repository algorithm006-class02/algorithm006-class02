// https://leetcode-cn.com/problems/sliding-window-maximum/solution/dan-diao-dui-lie-by-labuladong/
class MonotonicQueue {
  constructor() {
    this.queue = []
  }
  
  push(n) {
    while (this.queue.length && this.queue[this.queue.length - 1] < n) {
      this.queue.pop()
    }
    this.queue.push(n)
  } 
  pop(n) {
    if (this.queue.length && this.queue[0] === n) {
      this.queue.shift()
    }
  }
  max() {
    return this.queue[0]
  }
}

const mq = new MonotonicQueue()
mq.push(3)
mq.push(2)
// mq.push(4)
console.log(mq.queue)