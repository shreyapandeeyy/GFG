//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long a;
            a = Long.parseLong(br.readLine().trim());
            
            
            long b;
            b = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            long res = obj.sumOfPowers(a, b);
            
            System.out.println(res);
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends






class Solution {
    public static long sumOfPowers(long a, long b) {
        long sum = 0;
        for (long i = a; i <= b; i++) {
            sum += primeFactors(i);
        }
        return sum;
    }

    private static long primeFactors(long n) {
        long count = 0;
        long i = 2;
        while (i * i <= n) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                    count++;
                }
            }
            i++;
        }
        if (n > 1) {
            count++;
        }
        return count;
    }
}           
