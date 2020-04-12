/*
 * @lc app=leetcode.cn id=590 lang=javascript
 *
 * [590] N叉树的后序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/description/
 *
 * algorithms
 * Easy (71.15%)
 * Likes:    59
 * Dislikes: 0
 * Total Accepted:    19.6K
 * Total Submissions: 26.9K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其后序遍历: [5,6,3,2,4,1].
 * 
 * 
 * 
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
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
    const list = []
    const helper = (node, list) => {
        if (node === null) return
        const { children, children: { length } } = node
        if (length > 0) {
            for (let i = 0; i < length; i++) {
                helper(children[i], list)
            }
        }
        list.push(node.val)
    }
    helper(root, list)
    return list
};
// @lc code=end

