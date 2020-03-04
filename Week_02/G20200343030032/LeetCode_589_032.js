//n-ary-tree-preorder-traversal
class Node {
    constructor(val, children) {
        this.children = children;
        this.val = val;
    }
}

/**
 * sulotion1:recursion
 * @param {Node} root
 * @return {number[]}
 */
var preorder = function (root) {
    let box = [];
    if (root == null) return box;
    return preNode(root, box);
};

/**
 * @param {Node} node
 * @param {number[]} box
 * @return {number[]}
 */
function preNode(node, box) {
    box.push(node.val);
    for (item of node.children) {
        preNode(item, box);
    }
    return box;
}

/**
 * sulotion2:iteration
 * @param {Node} root
 * @return {number[]}
 */
var preorder2 = function (root) {
    if (root == null) return [];
    let queue = [root], box = [];
    while (queue.length > 0) {
        let node = queue.pop();
        box.push(node.val);
        node.children = node.children.reverse();
        for (item of node.children) {
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
console.log(preorder(node1));