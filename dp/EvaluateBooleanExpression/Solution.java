package EvaluateBooleanExpression;

public class Solution {
    static long mod=1000000007;

    static long fun(int i,int j,int isTrue,String a,long[][][] dp){
        if(i>j) return 0;

        if(i==j){
            if(isTrue==1){
                return a.charAt(i)=='T' ? 1 : 0;
            }else {
                return a.charAt(i)=='F' ? 1: 0;
            }
        }

        if(dp[i][j][isTrue] != -1) return dp[i][j][isTrue];
        long  ways=0;
        for(int ind=i+1;ind<j;ind=ind+2){
            long  lT=fun(i,ind-1,1,a,dp);
            long  lF=fun(i,ind-1,0,a,dp);
            long  rT=fun(ind+1,j,1,a,dp);
            long  rF=fun(ind+1,j,0,a,dp);

            if(a.charAt(ind)=='&'){
                if(isTrue==1){
                    ways=(ways+(lT*rT)%mod)%mod;
                }else{
                    ways=(ways+(lT*rF)%mod+(lF*rT)%mod+(lF*rF)%mod)%mod;
                }
            }else if(a.charAt(ind)=='|'){
                if(isTrue==1){
                    ways=(ways+(lT*rT)%mod+(lT*rF)%mod+(lF*rT)%mod)%mod;
                }else{
                    ways=(ways+(lF*rF)%mod)%mod;
                }
            }else if(a.charAt(ind)=='^'){
                if(isTrue==1){
                    ways=(ways+(lT*rF)%mod+(lF*rT)%mod)%mod;
                }else{
                    ways=(ways+(lT*rT)%mod+(lF*rF)%mod)%mod;
                }
            }
        }

        return dp[i][j][isTrue]=ways%mod;
    }
    public static int evaluateExp(String a) {
        int n=a.length();
        //return (int)fun(0,a.length()-1,1,a,dp);
        // Write your code here.
        long[][][] dp=new long[n][n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    dp[i][j][0]=a.charAt(i)=='F' ? 1: 0;
                    dp[i][j][1]=a.charAt(i)=='T' ? 1 :0;
                }
            }
        }

        for(int i=n-1;i>=0;i--){
            // be a smart when selecting j's value
            // and we already solved i==j therefore we are not taking it into account now
            for(int j=i+1;j<n;j++){
                if(i>j) continue;
                for(int isTrue=0;isTrue<=1;isTrue++){
                    long  ways=0;
                    for(int ind=i+1;ind<j;ind=ind+2){
                        long  lT=dp[i][ind-1][1];
                        long  lF=dp[i][ind-1][0];
                        long  rT=dp[ind+1][j][1];
                        long  rF=dp[ind+1][j][0];

                        if(a.charAt(ind)=='&'){
                            if(isTrue==1){
                                ways=(ways+(lT*rT)%mod)%mod;
                            }else{
                                ways=(ways+(lT*rF)%mod+(lF*rT)%mod+(lF*rF)%mod)%mod;
                            }
                        }else if(a.charAt(ind)=='|'){
                            if(isTrue==1){
                                ways=(ways+(lT*rT)%mod+(lT*rF)%mod+(lF*rT)%mod)%mod;
                            }else{
                                ways=(ways+(lF*rF)%mod)%mod;
                            }
                        }else if(a.charAt(ind)=='^'){
                            if(isTrue==1){
                                ways=(ways+(lT*rF)%mod+(lF*rT)%mod)%mod;
                            }else{
                                ways=(ways+(lT*rT)%mod+(lF*rF)%mod)%mod;
                            }
                        }
                    }
                    dp[i][j][isTrue]=ways;
                }
            }
        }


        return (int)dp[0][n-1][1];
    }
}
