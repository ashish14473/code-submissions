class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> bfsQueue = new LinkedList<>();
        int freshFruitsCount=0;
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[0].length;col++){
              if(grid[row][col]==2){
                bfsQueue.offer(new int[]{row,col});
              }else if(grid[row][col]==1){
                freshFruitsCount++;
              }
            }
        }
        if(freshFruitsCount==0){
            return 0;// no fresh fruits
        }
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        int minutes = 0;
        while(!bfsQueue.isEmpty() && freshFruitsCount >0){
            int queueSize = bfsQueue.size();
            for(int i=0;i<queueSize;i++){
                int[] rottedCell = bfsQueue.poll();
                for(int[] dir : directions){
                    int nr = rottedCell[0]+dir[0];
                    int nc = rottedCell[1]+dir[1];
                    if(nr >=0 && nc >= 0 && nr < grid.length && nc < grid[0].length  && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        freshFruitsCount--;
                         bfsQueue.offer(new int[]{nr, nc});

                    }
                }
            }

            minutes++;
        }

        return freshFruitsCount==0?minutes:-1;
    }
    
}
