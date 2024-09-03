//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java



//User function Template for Java

class Solution{
    
	int solve(String s1,String s2,int i,int j,int dp[][]){
        if(dp[i][j]!=-1) return dp[i][j];
        
        
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j] = solve(s1,s2,i+1,j+1,dp);
        
        //else case
        int insert = 1 + solve(s1,s2,i,j+1,dp);
        int delete = 1 + solve(s1,s2,i+1,j,dp);
        
        return dp[i][j] = Math.min(insert,delete);
    }
	public int minOperations(String s1, String s2) { 
	    int n = s1.length();
	    int m = s2.length();
	    int dp[][] = new int[n+1][m+1];
	    
	    for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
	    
	    //base case
	    for(int j=0;j<=m;j++) dp[n][j] = m-j;
	    for(int i=0;i<=n;i++) dp[i][m] = n-i;
	    
	    return solve(s1,s2,0,0,dp);
	} 
}