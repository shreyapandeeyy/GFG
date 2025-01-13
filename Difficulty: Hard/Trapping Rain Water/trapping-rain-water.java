//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    public int maxWater(int arr[]) {
        // code here
        int lmax=arr[0],rmax=arr[arr.length-1];
        int i=0,j=arr.length-1,sum=0;
        
        while(i<j)
        {
            if(arr[i]<=arr[j])
            {
                lmax=Math.max(lmax,arr[i]);
                sum+= lmax-arr[i];
                i++;
            }
            else
            {
                rmax=Math.max(rmax,arr[j]);
                sum+=rmax-arr[j];
                j--;
            }
        }
        return sum;
        
    }
}