public class SubSetSum {
    //Given an array of positive integers, arr[] and a value, target,
    // determine if there is a subset of the given set with sum equal to given target.

    //Input: arr[] = [3, 34, 4, 12, 5, 2], target = 9
    //Output: true
    //Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.

    private static boolean fun(int n,int target,int arr[],boolean[][] dp){
        if(target == 0)
            return true;
        if(n==0)
            return false;

        if(dp[n][target])    return dp[n][target];

        if(arr[n-1]<=target){
            return dp[n][target]=fun(n-1,target-arr[n-1],arr,dp) || fun(n-1,target,arr,dp);
        }
        else if(arr[n-1] > target)
            return dp[n][target]=fun(n-1,target,arr,dp);

        return false;
    }
    static Boolean isSubsetSum(int arr[], int target) {
        // code here
        int len=arr.length;
        boolean[][] dp=new boolean[len+1][target+1];

        //return fun(arr.length,target,arr,dp);

        // Bottom up approch

        // if target == 0, means its a subarray present with taking no element subarray
        for(int i=0;i<len+1;i++){
            dp[i][0]=true;
        }

        //using stream api
        // note : range() method is part of the IntStream class
        //in the java.util.stream package, not a method on arrays or matrices.
        // IntStream.range(0,len+1).forEach(i -> dp[i][0] = true);

        for(int i=1;i<len+1;i++){
            for(int j=1;j<target+1;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else if(arr[i-1] > j)
                    dp[i][j]=dp[i-1][j];
            }
        }
        // result present at the end
        //subarray possible with n element and target
        return dp[len][target];

    }
}
