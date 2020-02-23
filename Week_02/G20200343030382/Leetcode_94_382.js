/**
 * 二叉树的中序遍历
 */

//1、递归
var inorderTraversal = function(root) {
    let res = [];
    help(root, res);
    return res;
};

var help = function (root, res) {
    if (root != null) {
        if (root.left != null) {
            help(root.left, res);
        }
        res.push(root.val);
        if (root.right != null) {
            help(root.right, res);
        }
    }
}

//2. 迭代

function inorderTraversal2 (root) {
    let curr = root;
    let res = [];
    let stack = [];

    while (curr != null || stack.length != 0) {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        res.push(curr.val);
        curr = curr.right;
    }
    return res;
}

//3 莫里斯遍历

function inorderTraversal3 (root) {
    let curr  = root;
    let temp = {}, res = []; pre = {};

    while ( curr != null ) {
        if (curr.left == null) {
            res.push(curr.val);
            curr = curr.right;
        }else{
            pre = curr.left;
            while (curr.right != null){
                pre = pre.right;
            }
            pre.right = curr;
            temp = curr;
            curr = curr.left;
            temp.left = null;
        }
    }

    return res;
}

