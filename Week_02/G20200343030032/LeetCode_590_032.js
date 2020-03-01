// n-ary-tree-postorder-traversal
class Node {
    constructor(val, children) {
        this.children = children;
        this.val = val;
    }
}

/**
 * 递归
 * @param {Node} root
 * @return {number[]}
 */
var postorder = function (root) {
    if (root == null) return [];
    return postNode(root, []);
}

/**
 * @param {Node} node
 * @param {number[]} box
 * @return {number[]}
 */
function postNode(node, box) {
    for (let item of node.children) {
        postNode(item, box);
    }
    box.push(node.val);
    return box;
}

/**
 * 迭代
 * @param {Node} root
 * @return {number[]}
 */
var postorder2 = function (root) {
    if (root == null) return [];

    let queue = [root], box = [];
    while (queue.length > 0) {
        let node = queue.pop();
        box.unshift(node.val);
        for (let item of node.children) {
            queue.push(item);
        }
    }
    return box;
};

// case [1,null,3,2,4,null,5,6]
var node5 = new Node(5, []),
    node6 = new Node(6, []),
    node2 = new Node(2, []),
    node4 = new Node(4, []),
    node3 = new Node(3, [node5, node6]),
    node1 = new Node(1, [node3, node2, node4]);
console.log(postorder2(node1));