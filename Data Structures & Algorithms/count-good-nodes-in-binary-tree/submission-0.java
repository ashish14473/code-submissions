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
    int goodVals=0;
    public int goodNodes(TreeNode root) {
        dfs(root,-200);
        return goodVals;
    }

    public void dfs(TreeNode root, int maxVal){
        if(root == null ){
            return;
        }
       
        if(root.val>=maxVal){
            goodVals++;
        }
         maxVal = Math.max(maxVal,root.val);
        dfs(root.left,maxVal);
        dfs(root.right,maxVal);

    }
}
