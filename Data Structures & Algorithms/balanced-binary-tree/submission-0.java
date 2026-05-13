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
    int hd=0;
    public boolean isBalanced(TreeNode root) {
        isNotBalanced( root);
        System.out.println(hd);
        return hd<=1;
    }

    int isNotBalanced(TreeNode root){
        if(root==null){
            return 0;
        }

        int lh = isNotBalanced(root.left)+1;
        int rh = isNotBalanced(root.right)+1;
        hd = Math.max(hd,Math.abs(lh-rh));
        return Math.max(lh,rh);
    }
}
