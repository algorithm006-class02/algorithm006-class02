/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个 3叉树 :
 *
 * 返回其层序遍历:
 *
 * [
 * [1],
 * [3,2,4],
 * [5,6]
 * ]
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Node {
    constructor(val, children) {
        this.children = children;
        this.val = val;
    }
}

/**
 * 解法一：模拟队列实现bfs搜索
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder = function (root) {
    let queue = [root],
        values = [];
    if (root == null) return values;
    while (queue.length > 0) {
        let level = [], len = queue.length;
        for (let i = 0; i < len; i++) {
            let currentNode = queue.shift();
            level.push(currentNode.val);
            for (let child of currentNode.children) {
                queue.push(child);
            }
        }
        values.push(level);
    }
    return values;
};

/**
 * 解法二：简化版bfs搜索
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder2 = function (root) {
    let currentLayer = [root],
        values = [];
    if (root == null) return values;
    while (currentLayer.length > 0) {
        let level = [],
            nextLayer = [];
        for (let child of currentLayer) {
            level.push(child.val);
            for (let item of child.children) {
                nextLayer.push(item);
            }
        }
        values.push(level);
        currentLayer = nextLayer;
    }
    return values;
}

/**
 * 解法三：递归
 * @param {Node} root
 * @return {number[][]}
 */
var result = [];
var levelOrder3 = function (root) {
    if (root != null) {
        recursionNode(root, 0);
    }
    return result;
}

/**
 * @param {Node} root
 * @param {number} level
 */
var recursionNode = function (node, level) {
    if (result.length <= level) {
        result.push([]);
    }
    result[level].push(node.val);
    for (let child of node.children) {
        recursionNode(child, level + 1);
    }
}

// case [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
// right output [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
var node14 = new Node(14, []),
    node13 = new Node(13, []),
    node12 = new Node(12, []),
    node11 = new Node(11, [node14]),
    node10 = new Node(10, []),
    node9 = new Node(9, [node13]),
    node8 = new Node(8, [node12]),
    node7 = new Node(7, [node11]),
    node6 = new Node(6, []),
    node5 = new Node(5, [node9, node10]),
    node4 = new Node(4, [node8]),
    node3 = new Node(3, [node6, node7]),
    node2 = new Node(2, []),
    node1 = new Node(1, [node2, node3, node4, node5]);
console.log(levelOrder2(node1));
