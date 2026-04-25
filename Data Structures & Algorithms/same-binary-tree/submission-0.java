class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return rec(p,q);
    }

    boolean rec(TreeNode p, TreeNode q){
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        
        boolean l = rec(p.left,q.left);
        boolean r = rec(p.right,q.right);
        return l && r;
    }
}