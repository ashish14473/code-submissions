class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<Integer> current = new ArrayList<>();
        backtrack(result,used,current,nums);
        return result;
    }

    private static void backtrack(List<List<Integer>> result,boolean[] used,List<Integer> current, int[] nums){
        if(current.size()==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(used[i])continue;
            used[i]=true;
            current.add(nums[i]);
            backtrack(result, used, current, nums);
            current.remove(current.size()-1);
            used[i] = false;
        }
    }
}
