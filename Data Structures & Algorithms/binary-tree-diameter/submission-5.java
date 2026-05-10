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
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root); 
    }
     int diameter(TreeNode root) {
        if (root == null)
            return 0;

       

        // Get the diameter of left and right sub-trees
        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);
         // Get the height of left and right sub-trees
        int lheight = height(root.left);
        int rheight = height(root.right);

        return Math.max(lheight + rheight, 
                        Math.max(ldiameter, rdiameter));
    }

    int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int lc = height(root.left)+1;
        int rc = height(root.right)+1;
        return Math.max(lc,rc);
    }
}
