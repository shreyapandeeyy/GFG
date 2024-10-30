//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            
            int[] A = new int[N];
            int[] B = new int[M];
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);
                
            for(int i=0; i<M; i++)
                B[i] = Integer.parseInt(S2[i]);

            Solution ob = new Solution();
            System.out.println(ob.minInsAndDel(A,B,N,M));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution{
    static int minInsAndDel(int [] A, int[] B, int N, int M){
        // Create a set of elements in B for quick lookup
        Set<Integer> setB = new HashSet<>();
        for(int b : B){
            setB.add(b);
        }
        // Filter A to contain only elements that are in B
        List<Integer> filteredA = new ArrayList<>();
        for(int a : A){
            if(setB.contains(a)){
                 filteredA.add(a);
            }
        }
        // Find the LIS in filteredA relative to B
        List<Integer> lis = new ArrayList<>();
        for(int num : filteredA){
            int pos = Collections.binarySearch(lis,num);
            if (pos < 0){
                pos = -(pos + 1);
            }
            if (pos == lis.size()){
                lis.add(num);
            } else{
                lis.set(pos,num);
            }
        }
        // LIS length gives the longest subsequence that can be retained
        int lisLength = lis.size();
        // Calculate minimum insertions and deletions
        int deletions = N - lisLength;
        int insertions = M - lisLength;
        
        return deletions + insertions;
        
    }
}