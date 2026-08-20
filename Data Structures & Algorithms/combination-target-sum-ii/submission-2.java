class Solution {
   
      public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, new ArrayList<>(), result, target);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result, int target) {
      int sum = current.stream().reduce(0,(a,b)->a+b);
      if(sum ==target ){
          result.add(new ArrayList<>(current));
          
      }

      if(sum > target ){
          return;
          
      }
       
      
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            current.add(nums[i]);              // choose
            backtrack(nums, i+1 , current, result, target); // explore
            current.remove(current.size() - 1); // un-choose (backtrack)
        }
    }
}
