//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countTriangles(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java



// User function Template for Java

class Solution {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        Arrays.sort(arr);
        int count = 0;
        
        //3 4 6 7
        for(int i = arr.length - 1; i>=0; i--){
            count += greaterThan(arr, 0, i-1, arr[i]);
        }
        
        return count;
    }
    
    static int greaterThan(int[] arr, int s, int e, int t){
        int c = 0;
        
        //1 2 3 4 5
        while(s < e){
            int sum = arr[s] + arr[e];
            
            if(sum > t){
                c += (e-s);
                e--;
            }
            else{
                s++;
            }
        }
        
        return c;
    }
}