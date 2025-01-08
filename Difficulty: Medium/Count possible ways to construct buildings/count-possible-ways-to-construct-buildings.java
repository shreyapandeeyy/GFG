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
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.TotalWays(N);
            System.out.println(ans);           
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


//User function Template for Java




//User function Template for Java

class Solution
{
    public int TotalWays(int N)
    {
        int mod = 1000000007;
        int nobuild = 1;
        int build = 1;
        for(int i=2; i<=N; i++){
            int cbuild0 = (nobuild + build)%mod;
            int cbuild1 = nobuild;
            nobuild = cbuild0;
            build = cbuild1;
        }
        long ans = (nobuild+build)%mod;
        ans = (ans*ans)%mod;
        return (int) ans;
    }
}