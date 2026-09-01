class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxIlandSize =0;
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){ 
                maxIlandSize = Math.max(backtrack( r, c , grid),maxIlandSize);
                 
                
            }
        }
        return maxIlandSize;
    }

    public static int backtrack(int r, int c ,int[][] grid ){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]!=1 ){
            return 0;
        }
       
        grid[r][c]=2;
         int iSize = 1;  // count this cell
        iSize += backtrack(r + 1, c, grid);
        iSize += backtrack(r - 1, c, grid);
        iSize += backtrack(r, c + 1, grid);
        iSize += backtrack(r, c - 1, grid);
       //System.out.println(String.valueOf(r)+" "+String.valueOf(c)+" "+String.valueOf(iSize));
        return iSize;
    }
}
