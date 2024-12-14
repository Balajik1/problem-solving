public class NumberOfIslands {
    class Solution {
        public int numIslands(char[][] grid) {

            int rows=grid.length,cols=grid[0].length;
            int ct=0;
            int[][] vis=new int[rows][cols];
            for(int row=0;row<rows;row++){
                for(int col=0;col<cols;col++){
                    if(grid[row][col] == '1' && vis[row][col]==0){
                        ct++;
                        dfs(grid,vis,row,col);
                    }
                }
            }
            return ct;
        }
        void dfs(char[][] grid,int[][] vis,int r,int c){
            vis[r][c]=1;
            int[] row={0,-1,0,1};
            int[] col={-1,0,1,0};

            for(int k=0;k<4;k++){
                int currRow=r+row[k],currCol=c+col[k];
                if(currRow < 0 || currRow >= grid.length || currCol < 0 || currCol >=grid[0].length ){
                    continue;
                }
                if(grid[currRow][currCol]=='1' && vis[currRow][currCol]== 0){
                    dfs(grid,vis,currRow,currCol);
                }
            }
        }
    }
}
