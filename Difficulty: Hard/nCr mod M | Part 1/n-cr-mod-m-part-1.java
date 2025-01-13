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
            String[] s = br.readLine().trim().split(" ");
            long n = Long.parseLong(s[0]);
            long r = Long.parseLong(s[1]);
            Solution obj = new Solution();
            int ans = obj.nCr(n, r);
            System.out.println(ans);

        }
    }
}

// } Driver Code Ends


//User function Template for Java



//User function Template for Java

//User function Template for Java

class Solution
{
  
    private static final int MOD = 1000003;

    private long power(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }

    private long[] computeFactorials() {
        long[] fact = new long[MOD];
        fact[0] = 1;
        for (int i = 1; i < MOD; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        return fact;
    }

    private long nCrMod(long n, long r, long[] fact) {
        if (r > n) return 0;
        long numerator = fact[(int) n];
        long denominator = (fact[(int) r] * fact[(int) (n - r)]) % MOD;
        return (numerator * power(denominator, MOD - 2)) % MOD;
    }

    private long lucasTheorem(long n, long r, long[] fact) {
        if (r == 0) return 1;
        long nMod = n % MOD;
        long rMod = r % MOD;
        return (lucasTheorem(n / MOD, r / MOD, fact) * nCrMod(nMod, rMod, fact)) % MOD;
    }

    public int nCr(long n, long r) {
        long[] fact = computeFactorials();
        return (int) lucasTheorem(n, r, fact);
    
}

}