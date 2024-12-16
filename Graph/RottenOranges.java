import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    class Solution {
        class Pair{
            int row,col,ct;
            Pair(int row,int col,int ct){
                this.row=row;
                this.col=col;
                this.ct=ct;
            }
        }
        private int bfs(int[][] grid,int n,int m,Queue<Pair> q){
            int[][] vis=new int[n][m];
            int ct=0;
            int[] rows={0,-1,0,1};
            int[] cols={-1,0,1,0};

            while(!q.isEmpty()){
                Pair cell=q.poll();
                for(int k=0;k<rows.length;k++){
                    int currRow=cell.row+rows[k];
                    int currCol=cell.col+cols[k];
                    if(currRow < 0 || currRow >= n || currCol < 0 || currCol >= m){
                        continue;
                    }

                    if(grid[currRow][currCol] == 1){
                        // marking it rotted(Visited)
                        grid[currRow][currCol]=2;
                        q.add(new Pair(currRow,currCol,cell.ct+1));
                    }
                }
                ct=cell.ct;
            }
            return ct;
        }
        public int orangesRotting(int[][] grid) {
            int n=grid.length,m=grid[0].length;
            Queue<Pair> q=new LinkedList<>();
            int max=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(grid[i][j]==2)
                        q.add(new Pair(i,j,0));
                }
            }

            max=bfs(grid,n,m,q);

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(grid[i][j]==1)
                        return -1;
                }
            }
            return max;
        }
    }
}
