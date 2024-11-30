package MinCostToCutTheStick;
// class Solution {

//     public int fun(int i,int j,int[] cutts,int[][] dp){
//         if( i>j) return 0;
//         if(dp[i][j]!= -1) return dp[i][j];
//         int mini=Integer.MAX_VALUE;
//         for(int ind=i;ind<=j;ind++){
//             int cost = cutts[j+1]-cutts[i-1]+fun(i,ind-1,cutts,dp)+fun(ind+1,j,cutts,dp);
//             mini=Math.min(mini,cost);
//         }
//         dp[i][j]=mini;
//         return dp[i][j];
//     }
//     public int minCost(int n, int[] cuts) {

//         int len=cuts.length;
//         int[][] dp= new int[len+1][len+1];
//         for (int[] row : dp) {
//             Arrays.fill(row, -1);     // Fill each row with -1
//         }
//         Arrays.sort(cuts);
//         int[] cutts=new int[len+2];
//         cutts[0]=0;cutts[len+1]=n;
//         for(int i=1;i<=len;i++){
//             cutts[i]=cuts[i-1];
//         }
//         return fun(1,len,cutts,dp);
//     }
// }


import java.util.Arrays;

class Solution {
    public int minCost(int n, int[] cuts) {
        int len=cuts.length;
        int[][] dp= new int[len+2][len+2];
        Arrays.sort(cuts);
        int[] cutts=new int[len+2];
        cutts[0]=0;cutts[len+1]=n;
        for(int i=1;i<=len;i++){
            cutts[i]=cuts[i-1];
        }
        // write tabulation code here
        for(int i=len;i>=1;i--){
            for(int j=1;j<=len;j++){
                if(i>j) continue;
                int mini=Integer.MAX_VALUE;
                for(int ind=i;ind<=j;ind++){
                    int cost = cutts[j+1]-cutts[i-1]+dp[i][ind-1]+dp[ind+1][j];
                    mini=Math.min(mini,cost);
                }
                dp[i][j]=mini;
            }
        }
        return dp[1][len];
    }
}