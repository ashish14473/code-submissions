class Solution {
   public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    int INF = Integer.MAX_VALUE;
    int[] dist = new int[n];
    Arrays.fill(dist, INF);
    dist[src] = 0;

    for (int i = 0; i <= k; i++) {          // k stops = k+1 flights
        int[] temp = dist.clone();          // write into a copy
        for (int[] f : flights) {
            int u = f[0], v = f[1], w = f[2];
            if (dist[u] != INF && dist[u] + w < temp[v]) {
                temp[v] = dist[u] + w;      // read from old dist only
            }
        }
        dist = temp;
    }
    return dist[dst] == INF ? -1 : dist[dst];
}
}
