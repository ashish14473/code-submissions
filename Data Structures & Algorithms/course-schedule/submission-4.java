class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0){
            return true;
        }
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] prereq : prerequisites){
            if(map.containsKey(prereq[1])){
                map.get(prereq[1]).add(prereq[0]);
            }else{
                map.put(prereq[1],new ArrayList(List.of(prereq[0])));
            }

        }
        Set<Integer>  visited = new HashSet<>();
        List<Integer>  resStack = new LinkedList<>();
        
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            
            if(!visited.contains(entry.getKey()) && hasCycle( map, visited ,entry.getKey(), resStack)){
                return false;
            }
        }

       return true;
    }

    boolean hasCycle(Map<Integer,List<Integer>>  map,Set<Integer> visited,Integer node, List<Integer> resStack){
        if(resStack.contains(node)){
            return true;
        }
        if(visited.contains(node)){
            return false;
        }

        visited.add(node);
        resStack.addLast(node);
        List<Integer> neighbours = map.get(node);
        if(neighbours != null){
             for(Integer neighbour : neighbours){
            if( hasCycle(map,visited,neighbour,resStack)){
                return true;
            }
        }
        }
       resStack.removeLast();
        return false;
    }
}
