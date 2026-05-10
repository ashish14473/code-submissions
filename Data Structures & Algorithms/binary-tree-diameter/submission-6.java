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

    int maxdia =0;
    public int diameterOfBinaryTree(TreeNode root) {
         diameter(root); 
         return maxdia;
    }
     int diameter(TreeNode root) {
        if (root == null)
            return 0;

       

        // Get the diameter of left and right sub-trees
        int lheight = diameter(root.left);
        int rheight = diameter(root.right);

        if(lheight+rheight > maxdia){
                maxdia = lheight+rheight;
        }
        
        return 1+Math.max(lheight ,rheight);
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
