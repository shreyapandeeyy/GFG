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
            System.out.println(new Solution().trappingWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    public int trappingWater(int arr[]) {
        // code here
        int res=0;
        int[] lmax=new int[arr.length];
        int[] rmax=new int[arr.length];
        lmax[0]=arr[0];
        for(int i=1;i<lmax.length;i++){
            lmax[i]=Math.max(arr[i],lmax[i-1]);
        }
        rmax[rmax.length-1]=arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            rmax[i]=Math.max(arr[i],rmax[i+1]);
        }
        
        for(int i=1;i<arr.length-1;i++){
            res=res+(Math.min(rmax[i],lmax[i])-arr[i]);
        }
        return res;
    }
}