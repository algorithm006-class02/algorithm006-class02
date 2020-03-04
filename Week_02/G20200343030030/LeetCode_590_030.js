/*
 * @lc app=leetcode.cn id=590 lang=javascript
 *
 * [590] N叉树的后序遍历
 */

// @lc code=start
/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */
var postorder = function(root) {
    if(!root) return []
    var list = [];
    (function (root){
    if(!root) return
    root.children.forEach(item=>{
      arguments.callee(item)
    })
    list.push(root.val)
  })(root)
  return list

};
// @lc code=end

