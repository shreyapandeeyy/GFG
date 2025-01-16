//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Create BufferedReader for efficient input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of test cases
        int T = Integer.parseInt(br.readLine());

        // Process each test case
        while (T-- > 0) {
            // Read the entire line containing the array elements
            String line = br.readLine();

            // Split the line into an array of strings, then parse them as integers
            String[] tokens = line.split("\\s+");
            int[] a = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                a[i] = Integer.parseInt(tokens[i]);
            }

            // Create the Solution object
            Solution obj = new Solution();

            // Call maxLen function and print the result
            System.out.println(obj.maxLen(a));
        }
    }
}
// } Driver Code Ends




class Solution {
    public int maxLen(int[] arr) {
        // Your code here
        /*int n=arr.length,ocount=0,zcount=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(arr[j]==0){
                zcount++;
                }
                else{
                    ocount++;
                }
                
                if(zcount==ocount){
                    max=Math.max(max,j-i);
                }
            
            }
            
        }
        return max;*/
        
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        
        int max=0,count=0;
        for(int i=0;i<n;i++){
            
            count+=(arr[i]==0)?-1:1;
            
            if(map.containsKey(count)){
                max=Math.max(max,i-map.get(count));
            }
            else{
                map.put(count,i);
            }
            
        }
        return max;
    }
}