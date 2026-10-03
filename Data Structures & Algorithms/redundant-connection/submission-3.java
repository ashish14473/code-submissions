class Solution {
    static int[] rank ; 
    static int[] parent ; 
    
    public int[] findRedundantConnection(int[][] edges) {
        rank = new int[edges.length+1]; 
        parent = new int[edges.length+1]; 
        int[] res = new int[2];
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        for(int[] edge : edges){
            int x = edge[0];
            int y = edge[1];
            if(find(x) != find(y)){
                union( x,  y);
            }else{
                
                res[0] = x;
                res[1] = y;
                return res;
            }
        }
        return res;
    }

    public static int find(int i) {
        System.out.println(i);
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public static void union(int x, int y) {
        int s1 = find(x);
        int s2 = find(y);
        if (s1 != s2) {
            if (rank[s1] < rank[s2]) {
                parent[s1] = s2;
            } else if (rank[s1] > rank[s2]) {
                parent[s2] = s1;
            } else {
                parent[s2] = s1;
                rank[s1]++;
            }
        }
    }
}
