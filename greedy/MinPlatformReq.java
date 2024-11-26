
// User function Template for Java

import java.util.Arrays;

public class MinPlatformReq {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i=0,j=0;
        int n=arr.length,m=dep.length;
        int max=0,ct=0;
        while(i<n && j<m){
            if(arr[i]<=dep[j]){
                ct++;
                i++;
            }else{
                ct--;
                j++;
            }
            max=Math.max(ct,max);
        }
        return max;



    }
}
