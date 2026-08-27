class Solution {
    public static List<String> generateParenthesis(int n) {
    StringBuilder sb = new StringBuilder();
    List<String> res = new ArrayList<>();
    backtrack(res, sb, 0, 0, n);
    return res;
    }

    private static void  backtrack(List<String> res, StringBuilder sb, int left, int right, int n){
        if(sb.length() == 2 * n){
            res.add(sb.toString());
            return;
        }
        if(left < n){
            sb.append("(");
            backtrack(res,  sb,  left+1,  right,  n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(left > right){
            sb.append(")");
            backtrack(res,  sb,  left,  right+1,  n);
            sb.deleteCharAt(sb.length()-1);

    }
    }
}
