/*
 * @lc app=leetcode.cn id=590 lang=javascript
 *
 * [590] N叉树的后序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/description/
 *
 * algorithms
 * Easy (72.10%)
 * Likes:    50
 * Dislikes: 0
 * Total Accepted:    16.1K
 * Total Submissions: 22.3K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]\r'
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
// P(root) = root.children.forEach(item => P(item)) + root.value;
// 终止条件：
// root.children.length === 0
var postorder = function(root) {
    if (!root) return [];

    var res = [];
    recusion(root);
    return res;

    function recusion(root){
        if (!root) return;

        for (var i = 0; i < root.children.length; i++){
            recusion(root.children[i]);
        }
        res.push(root.val)
    }
};

// 2-迭代法
// 迭代循环——双重循环
// 1、结构动态拍平
// 2、循环
// 注意动态取值顺序对应不同遍历

// var postorder = function(root) {
//     if (!root) return [];
//     let i = 0;
//     let res = [],
//         arr = [root];
//     while(arr.length) {
//         // 取出
//         const current = arr.pop();
//         for (let i = 0; i < current.children.length; i++) {
//             arr.push(current.children[i]);
//         }
//         res.unshift(current.val);
//     }
//     return res;
// }

// 下面是没想清楚写的有问题的解法：
// var postorder = function(root) {
//     if (!root) return [];
//     let children = root.children || [],
//         res = [[root]];
//     while(children.length) {
//         res.push(children);
//         let _children = [];
//         children.forEach(item => {
//             if (item.children) _children.push(...item.children);
//         })
//         children = _children;
//     }
//     return res.reverse().reduce((acc, curr) => {
//         console.log(curr.map(item => item.val));
//         return acc.concat(curr.map(item => item.val))
//     }, []);
// }


// @lc code=end

