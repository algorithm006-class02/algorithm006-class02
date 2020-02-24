/*
 * @lc app=leetcode.cn id=589 lang=javascript
 *
 * [589] N叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 *
 * algorithms
 * Easy (72.01%)
 * Likes:    66
 * Dislikes: 0
 * Total Accepted:    18.3K
 * Total Submissions: 25.4K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * 
 * 
 * 
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */

// @lc code=start
/**
 * // Definition for a Node.
 * function Node(val, children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */

 /*
{
    "val": 1,
    "children": [
        {
            "val": 3,
            "children": [
                {
                    "val": 5,
                    "children": []
                },
                {
                    "val": 6,
                    "children": []
                }
            ]
        },
        {
            "val": 2,
            "children": []
        },
        {
            "val": 4,
            "children": []
        }
    ]
}

*/

// 1-递归法
// 递推公式：
// P(root) = root.value + root.children.forEach(item => P(item));
// 终止条件：
// root.children.length === 0
var preorder = function(root) {
    if (!root) return [];
    let res = [root.val];
    if (root.children.length === 0) return res;
    root.children.forEach(node => {
        res.push(node.val);
        preorder(node);
    });
    return res;
};

// 2-迭代法
// 迭代循环——双重循环
// 1、结构动态拍平
// 2、循环
// 注意动态取值顺序对应不同遍历

// var preorder = function(root) {
//     if (!root) return [];
//     let i = 0;
//     let res = [],
//         arr = [root];
//     while(arr.length) {
//         // 取出
//         const current = arr.pop();
//         res.push(current.val);
//         for (let i = current.children.length - 1; i >= 0; i--) {
//             arr.push(current.children[i]);
//         }
//     }
//     return res;
// }

// @lc code=end

