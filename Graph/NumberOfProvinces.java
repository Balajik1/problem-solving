public class NumberOfProvinces {

    class Solution {
        public int findCircleNum(int[][] isConnected) {
            int row = isConnected.length, col = isConnected[0].length;
            int[] vis = new int[row];
            int provinces = 0;
            for (int i = 0; i < row; i++) {
                if (vis[i] == 0) {
                    dfs(isConnected, i, vis);
                    provinces++;
                }
            }
            return provinces;
        }

        void dfs(int[][] isConnected, int node, int[] vis) {
            vis[node] = 1;
            // adding to dfs list or print step

            // traversing over all conected node of it

            for (int i = 0; i < isConnected.length; i++) {
                if (vis[i] == 0 && isConnected[node][i] == 1) {
                    dfs(isConnected, i, vis);
                }
            }
        }
    }
}