/**
 * initialize your data structure here.
 */
var MinStack = function () {
  this.stack = []
  this.minStack = []
  this.pos = -1
  this.min = null
};

/**
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function (x) {
  if (this.pos == -1 || x <= this.min) {
    this.min = x
    this.minStack.push(x)
  }
  this.stack[++this.pos] = x
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function () {
  if (this.pos == 0) {
    this.pos--
    this.min = null
    this.minStack.length = 0
  } else if (this.pos > 0) {
    let top = this.top()
    this.pos--
    let index = this.minStack.length - 1
    if (top === this.min && index) {
      this.min = this.minStack[index - 1]
      this.minStack.length = index
    }
  }
};

/**
 * @return {number}
 */
MinStack.prototype.top = function () {
  return this.stack[this.pos]
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function () {
  return this.min
};

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */