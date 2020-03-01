=begin
  题目描述：给定一个二叉树，返回它的 前序 遍历。
  输入：[1,null,2,3] 
  输出：[1,2,3] 
=end

#解法一、使用递归法，依次遍历当前节点及其左右子节点
def preorder_traversal(root)
  result = []
  get_result(root, result)
  return result
end

def get_result(root, result)
  return if !root
  result.push(root.val)
  get_result(root.left, result) if root.left
  get_result(root.right, result) if root.right
end


#解法二、使用循环和栈，将当前节点和其左右子节点依次压入栈中，然后逐次出栈，直到栈为空
def preorder_traversal(root)
  result = []
  return []unless root
  stack = []
  stack.push(root)
  while !stack.empty?
    node = stack.pop
    result.push(node.val)
    stack.push(node.right) if node.right
    stack.push(node.left) if node.left
  end
  result
end