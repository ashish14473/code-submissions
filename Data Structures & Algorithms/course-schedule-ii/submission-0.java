class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        
        int[] indegree = new int[numCourses];
        for(int[] pre : prerequisites){
            if(graph.containsKey(pre[1])){
                 graph.get(pre[1]).add(pre[0]);   
            }else{
                graph.put(pre[1],new ArrayList<>(List.of(pre[0])));
            }
            indegree[pre[0]]++;
        }

      

       Queue<Integer> queue = new LinkedList<>();
       for(int i=0;i<indegree.length;i++){
        
            if(indegree[i]==0){
                queue.add(i);
            }
       }
        List<Integer> result = new LinkedList<>();
       while(!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);
            List<Integer> neighbours = graph.get(node);
            if(neighbours!=null){
                for(Integer neighbour : neighbours){
                    indegree[neighbour]--;
                    if(indegree[neighbour]==0){
                        queue.add(neighbour);
                    }
                }
            }
       }

       return result.size()==numCourses ? result.stream().mapToInt(Integer::intValue).toArray() : new int[0];
    }
}
