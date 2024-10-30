//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            t--;

            System.out.println(new Solution().findsum(arr) == true ? "true" : "false");
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[]) {
        HashMap<Integer,Integer>hm = new HashMap<>();
        int sum = 0;
        int count=0;
       int len=0;
        for(int i=0;i<arr.length;i++){
            sum = sum + arr[i];
            if(sum == 0){
              count++;
             // if(len<i-hm.get(sum))
             // len=i-hm.get(sum);
             // System.out.println("--"+count);
                return true;
            }
            else if(!hm.containsKey(sum)){
                hm.put(sum,i);
            }
            else{
                count++;
                 //   if(len<i-hm.get(sum))
             // len=i-hm.get(sum);
              //  System.out.println("--"+count);
                return true;
            }
        }
       // System.out.println("--"+count+"--"+len);
        return false;
    }
}