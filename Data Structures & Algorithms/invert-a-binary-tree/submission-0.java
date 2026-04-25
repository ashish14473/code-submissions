/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        postOrderHelper(root);
        return root;
    }


   void postOrderHelper(TreeNode node) {
        if (node == null) return;
        postOrderHelper(node.left);    // LEFT
        postOrderHelper(node.right);   // RIGHT
       TreeNode temp;
       temp = node.left;
       node.left = node.right;
       node.right = temp;
    }

}
