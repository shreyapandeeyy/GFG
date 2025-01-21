//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            int[] ans = new int[n];
            ans = ob.productExceptSelf(arr);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            System.out.println("~");
            t--;
        }
    }
}

// } Driver Code Ends

// User function Template for Java
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        int n=arr.length;
        int l[]=new int[n];
        int r[]=new int[n];
        int re[]=new int[n];
        l[0]=1;
        r[n-1]=1;
        for(int i=1;i<n;i++){
            l[i]=l[i-1]*arr[i-1];
        }
        for(int i=n-2;i>=0;i--){
            r[i]=r[i+1]*arr[i+1];
        }
        for(int i=0;i<n;i++){
            re[i]=l[i]*r[i];
        }
        return re;
    }
}
