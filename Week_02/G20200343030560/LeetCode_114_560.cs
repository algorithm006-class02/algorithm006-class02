using System;
using System.Collections.Generic;
using System.Text;

namespace MaxArea
{
    public class TreeNode
    {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }
    public class LeetCode_114_560
    {
        public IList<int> PreorderTraversal(TreeNode root)
        {
            List<int> list = new List<int>();
            preorderTraversal(root, list);
            return list;
        }
        private static void preorderTraversal(TreeNode root, List<int> list)
        {
            if (root == null)
            {
                return;
            }
            list.Add(root.val);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);

        }
    }
}
