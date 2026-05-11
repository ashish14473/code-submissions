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
    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>(); 
        List<Integer> result = new ArrayList<>();
        queue.add(root);
        
        while(!queue.isEmpty() && root!=null ){
            int size = queue.size();

            for(int i=0;i<size;i++){
               TreeNode node =  queue.poll();
               if(node.left!=null){
                 queue.add(node.left);
               }
                if(node.right!=null){
                 queue.add(node.right);
               }
               if(i==size-1){
                result.add(node.val);
               }
            }
          
        }

        return result;


    }
}
