//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.TotalCount(str);
            System.out.println(ans);           
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


//User function Template for Java



//User function Template for Java

class Solution {
public int TotalCount(String str) {
int length = str.length();
int maxSum = 9 * length;
int[][] counts = new int[length + 1][maxSum + 1];
int[] prefixSums = new int[length + 1];

   for (int i = 1; i <= length; i++) {
        prefixSums[i] = prefixSums[i - 1] + (str.charAt(i - 1) - '0');
    }

    for (int i = 1; i <= length; i++) {
        counts[i][prefixSums[i]]++;
        for (int j = i; j >= 2; j--) {
            int currentSum = prefixSums[i] - prefixSums[j - 1];
            for (int k = currentSum; k >= 0; k--) {
                counts[i][currentSum] += counts[j - 1][k];
            }
        }
    }

    int result = 0;
    for (int i = 0; i <= maxSum; i++) {
        result += counts[length][i];
    }

    return result;
}

}