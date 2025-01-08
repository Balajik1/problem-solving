package DpOnString;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        class Solution {
            int fun(int i,int j,int n,int m,String s1,String s2,int[][] dp){
                if(i==0 || j==0){
                    return 0;
                }
                if(dp[i-1][j-1]!= -1) return dp[i-1][j-1];
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    return dp[i-1][j-1]= 1+fun(i-1,j-1,n,m,s1,s2,dp);
                }
                return dp[i-1][j-1]=Math.max(fun(i-1,j,n,m,s1,s2,dp),fun(i,j-1,n,m,s1,s2,dp));
            }
            public int longestCommonSubsequence(String text1, String text2) {
                int n=text1.length(),m=text2.length();
                //int[][] dp=new int[n][m];
                // for(int i=0;i<n;i++){
                //     Arrays.fill(dp[i],-1);
                // }
                // return dp[n-1][m-1]=fun(n,m,n,m,text1,text2,dp);

                // Tabulation : Bottom UP

                int[][] dp=new int[n+1][m+1];
                for(int i=1;i<=n;i++){
                    for(int j=1;j<=m;j++){
                        if(text1.charAt(i-1)==text2.charAt(j-1)){
                            dp[i][j]=1+dp[i-1][j-1];
                        }else{
                            dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                        }
                    }
                }
                return dp[n][m];
            }
        }
    }
}
