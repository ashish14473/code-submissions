class Solution {
    public int countComponents(int n, int[][] edges) {

        Map<Integer,List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for(int[] edge : edges){
            if(map.containsKey(edge[0])){
                List<Integer> vals = map.get(edge[0]);
                vals.add(edge[1]);
                
            }else{
                map.put(edge[0], new ArrayList<>(List.of(edge[1])));
            }

            if(map.containsKey(edge[1])){
                List<Integer> vals = map.get(edge[1]);
                vals.add(edge[0]);
                
            }else{
                map.put(edge[1], new ArrayList<>(List.of(edge[0])));
            }
        }
        for(int i=0;i<n;i++){
             if(!map.containsKey(i)){
                 map.put(i, new ArrayList<>());
             }
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " -> " + entry.getValue());
}
        int connet=0;
       for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if(!visited.contains(entry.getKey())){
                connet++;
                dfs(map,visited,entry.getKey());
            }

        }

    return connet;

    }

    void dfs( Map<Integer,List<Integer>> map, Set<Integer> visited,Integer node ){
        if(visited.contains(node)){
            return;
        }
        visited.add(node);
        List<Integer> neighbours = map.get(node);
        for(Integer neighbour : neighbours){
            dfs( map,  visited, neighbour );
        }
    }
}
