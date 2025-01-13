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


// User function Template for Java



// User function Template for Java

class Solution {

    public int maxWater(int arr[]) {
        int n = arr.length;
        int left=0, right=n-1;
        int maxWater=0;
        
        while(left<right){
            int width = right-left;
            int height = Math.min(arr[left], arr[right]);
            int area = width * height;
            maxWater= Math.max(maxWater, area);
            
            if(arr[left] < arr[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxWater;
    }
}