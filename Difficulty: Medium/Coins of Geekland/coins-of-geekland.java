//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int a[][] = new int[n][n];
		    
		    for(int i=0;i<n;i++)
		    {
		        for(int j=0;j<n;j++)
		        {
		            a[i][j] = Integer.parseInt(sc.next());
		        }
		    }
		    
		    int k = Integer.parseInt(sc.next());
		    Solution T = new Solution();
		    System.out.println(T.Maximum_Sum(a,n,k));
		
System.out.println("~");
}
	}
}
// } Driver Code Ends



class Solution
{
    public int Maximum_Sum(int mat[][],int N,int k){
        // Your code goes here
        
        int mx = Integer.MIN_VALUE;
        int temp[][] = new int[N+1][N+1];
        
        for(int i=0 ; i <=N ; i++){
            for(int j = 0 ; j <=N ; j++){
             if(i == 0 || j == 0){
                 temp[i][j]=0;
                 
             }
             else{
                 temp[i][j] = mat[i-1][j-1]+temp[i-1][j]+temp[i][j-1]-temp[i-1][j-1];
                
             }
           
             if(i >= k && j >=k){
                  int currentSum = temp[i][j] -
                                 temp[i - k][j] -
                                 temp[i][j - k] +
                                 temp[i - k][j - k];
                 mx = Math.max(currentSum ,mx);
             }
            }
        }
        return mx;
    }
}