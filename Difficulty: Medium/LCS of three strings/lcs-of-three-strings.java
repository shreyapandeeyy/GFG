//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s1 = read.readLine();
            String s2 = read.readLine();
            String s3 = read.readLine();
            Solution obj = new Solution();
            System.out.println(obj.LCSof3(s1, s2, s3));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// User function Template for Java
class Solution {
    int LCSof3(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        
        if (n1 == 0 || n2 == 0 || n3 == 0){
            return 0;
        }
        
        int[][][] result = new int[n1 + 1][n2 + 1][n3 + 1];
        
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                for (int k = 0; k <= n3; k++) {
                    if (i == 0 || j == 0 || k == 0) {
                        result[i][j][k] = 0;  
                    }
                    else if (s1.charAt(i - 1)== s2.charAt(j - 1) && s1.charAt(i - 1) == s3.charAt(k - 1)){
                        result[i][j][k] = result[i - 1][j - 1][k - 1] + 1;  
                    }
                    else {
                        result[i][j][k] = Math.max(Math.max(result[i - 1][j][k],result[i][j - 1][k]),result[i][j][k - 1]);  
                    }
                }
            }
        }

        return result[n1][n2][n3];
    }
}