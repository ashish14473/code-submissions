class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result, target);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result, int target) {
      int sum = current.stream().reduce(0,(a,b)->a+b);
      if(sum ==target ){
          result.add(new ArrayList<>(current));
          return;
      }
       if(sum > target ){
         return;
      }
      
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);              // choose
            backtrack(nums, i , current, result, target); // explore
            current.remove(current.size() - 1); // un-choose (backtrack)
        }
    }
}
