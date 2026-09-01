class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int numIlands =0;
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]=='1'){
                    numIlands++;
                    backtrack( r, c , grid);
                }
            }
        }
        return numIlands;
    }

    public static void backtrack(int r, int c ,char[][] grid){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]!='1'){
            return;
        }
        grid[r][c]='0';
        if(r+1 < grid.length && grid[r+1][c]=='1'){
             backtrack( r+1,  c , grid);
        }
        
        if(r+1 < grid.length && grid[r+1][c]=='1'){
            backtrack(r+1, c, grid);
        }
        if(r-1 >= 0 && grid[r-1][c]=='1'){
            backtrack(r-1, c, grid);
        }
        if(c+1 < grid[0].length && grid[r][c+1]=='1'){
            backtrack(r, c+1, grid);
        }
        if(c-1 >= 0 && grid[r][c-1]=='1'){
            backtrack(r, c-1, grid);
        }
            }
}
