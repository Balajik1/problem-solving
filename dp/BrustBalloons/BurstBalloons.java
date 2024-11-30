package BrustBalloons;

public class BurstBalloons {
}
class Solution {

    private int fun(int i,int j,int[] nums,int[][] dp){
        if( i>j) return 0;
        if(dp[i][j]!= -1) return dp[i][j];
        int maxi=Integer.MIN_VALUE;
        for(int ind=i;ind<=j;ind++){
            int cost = nums[i-1]*nums[ind]*nums[j+1] +fun(i,ind-1,nums,dp)+fun(ind+1,j,nums,dp);
            maxi=Math.max(maxi,cost);
        }
        dp[i][j]=maxi;
        return dp[i][j];
    }

    // public int maxCoins(int[] nums) {
    //     int len=nums.length;
    //     int[][] dp= new int[len+1][len+1];
    //     for (int[] row : dp) {
    //         Arrays.fill(row, -1);     // Fill each row with -1
    //     }
    //     int[] numms=new int[len+2];
    //     numms[0]=1;numms[len+1]=1;
    //     for(int i=1;i<=len;i++){
    //         numms[i]=nums[i-1];
    //     }
    //     return fun(1,len,numms,dp);
    // }


    public int maxCoins(int[] nums) {
        int len=nums.length;
        int[][] dp= new int[len+2][len+2];

        int[] numms=new int[len+2];
        numms[0]=1;numms[len+1]=1;
        for(int i=1;i<=len;i++){
            numms[i]=nums[i-1];
        }

        for(int i=len;i>=1;i--){
            for(int j=1;j<=len;j++){
                if(i>j) continue;
                int maxi=Integer.MIN_VALUE;
                for(int ind=i;ind<=j;ind++){
                    int cost = numms[i-1]*numms[ind]*numms[j+1] +dp[i][ind-1]+dp[ind+1][j];
                    maxi=Math.max(maxi,cost);
                }
                dp[i][j]=maxi;
            }
        }
        return dp[1][len];
    }
}