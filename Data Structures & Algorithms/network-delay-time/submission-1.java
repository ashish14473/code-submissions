class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> graph = new HashMap<>();
        for(int[] time : times){
            if(graph.containsKey(time[0])){
                graph.get(time[0]).add(new int[]{time[1], time[2]});
            }else{
                List<int[]> edge= new ArrayList<>();
                edge.add(new int[]{time[1], time[2]});
                graph.put(time[0],edge);
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
       
        while(!pq.isEmpty()){
            int[] val = pq.poll();
            int u = val[1];
            int d = val[0];
           
            List<int[]> neighbours = graph.get(u);
            if(neighbours!=null){
                for(int[] neighbour : neighbours){
                    if(neighbour[1]+ dist[u] < dist[neighbour[0]]){
                        dist[neighbour[0]] = neighbour[1]+ dist[u];
                        pq.offer(new int[]{ dist[neighbour[0]], neighbour[0]});
                    }
                }
            }

        }
        int max =-1;
        for(int i=1;i<dist.length;i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            if(dist[i]>max){
                max = dist[i];
            }
        }
        return max;
    }
}
