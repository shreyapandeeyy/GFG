//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.count(N));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java



//User function Template for Java

class Solution{
    /*public static int fact(int num){
        int fact = 1;
        for(int i = 2; i<=num; i++){
            fact *= i;
        }
        return fact;
    }*/
    static int count(int N) 
    { 
        // code here
        int cat = 1;
       if(N % 2 != 0){
           return 0;
       }   
       int pair = N/2;
       for(int i = 0; i< pair; i++){
           cat = cat * (2 * (2*i+1)) / (i + 2);
           
       }
       return cat;
    }
}