//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution {
    static int minJumps(int[] arr) {
        // code here
        // int i=0;
        // int maxI=0;
        // for(int j:arr)
        // {
        //     if(j<=maxI)
        //     return false;
            
        //     maxI=Math.max(maxI,i+j);
        //     i++;
        // }
        // return true;
        
        int l=0;
        int r=0;
        int j=0;
        int n=arr.length;
        // int max=Integer.MIN_VALUE;
        while (r<n-1)
        {
            int farthest=0;
            for(int i=l;i<=r;i++)
            {
                farthest=Math.max(farthest,i+arr[i]);
            }
            if(farthest<=r)
            return -1;
            l=r+1;
            r=farthest;
            j++;
        }
        return j;
    }
}