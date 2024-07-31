//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java



// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here
        int n = arr.length;
        
        StringBuilder ans = new StringBuilder();
        Arrays.sort(arr);
        
        int first = arr[0].length();
        int last = arr[n-1].length();
        
        for (int i = 0; i < (int)Math.min(first, last); i++) {
            if(arr[0].charAt(i) != arr[n-1].charAt(i)){
                break;
            }
            ans.append(arr[0].charAt(i));
        }
        
        if(ans.length() == 0){
            return "-1";
        }
        
        return ans.toString();
        
    }
}