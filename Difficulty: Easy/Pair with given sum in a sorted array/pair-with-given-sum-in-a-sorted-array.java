//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

// User function Template for Java

// // User function Template for Java

class Solution {

    int countPairs(int arr[], int target) {
        // Complete the function
        int ans = 0;
       HashMap<Integer, Integer> map = new HashMap<>();
       for(int i = 0; i < arr.length; i++){
           if(map.containsKey(target - arr[i])){
               ans += map.get(target-arr[i]);
           }
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
       }
        return ans;
    }
}


//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int target = Integer.parseInt(inputLine[0]);

            Solution obj = new Solution();
            int res = obj.countPairs(arr, target);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends