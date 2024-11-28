

//Given an integer array nums, return true if you can partition the array
// into two subsets such that the sum of the elements in both subsets is equal
// or false otherwise.

//Example 1:
//
//Input: nums = [1,5,11,5]
//Output: true
//Explanation: The array can be partitioned as [1, 5, 5] and [11].

// Example 2:
//Input: nums = [1,2,3,5]
//Output: false
//Explanation: The array cannot be partitioned into equal sum subsets.

class Solution {
    public boolean canPartition(int[] arr) {
        // code here

        //slightly slower than a plain loop due to the overhead of stream creation and
        //function calls but is compact.
        //int sum = IntStream.of(arr).sum();

        int sum=0;

        int len=arr.length;

        for(int i=0;i<len;i++){
            sum+=arr[i];
        }

        int target=sum/2;

        if(sum%2 != 0) return false;

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

public class PartitionEqualSum {
}
