class Solution {
    public List<String> letterCombinations(String digits) {
         List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        Map<Character,String> numToCharMap = new HashMap<>();
        numToCharMap.put('2',"abc");
        numToCharMap.put('3',"def");
        numToCharMap.put('4',"ghi");
        numToCharMap.put('5',"jkl");
        numToCharMap.put('6',"mno");
        numToCharMap.put('7',"pqrs");
        numToCharMap.put('8',"tuv");
        numToCharMap.put('9',"wxyz");

        backtrack(numToCharMap,result, 0,"",digits );
return result;
       

    }

    private static void backtrack(Map<Character,String> numToCharMap,List<String> result,int depth,String current,String digits){
        if(depth == digits.length()){
            result.add(current);
            return;
        }
        String letters = numToCharMap.get(digits.charAt(depth));
        for(int i = 0 ; i <letters.length(); i++){
            backtrack(numToCharMap,result,depth+1,current+letters.charAt(i),digits);
        }

    } 
}
