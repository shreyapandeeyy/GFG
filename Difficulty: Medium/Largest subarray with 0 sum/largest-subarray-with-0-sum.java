//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        
System.out.println("~");
}
    }
}
// } Driver Code Ends




class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        int maxi=0;
        int prefixsum=0;
        HashMap<Integer,Integer> M=new HashMap<>();
        for(int i=0;i<n;i++){
            prefixsum+=arr[i];
            if(prefixsum==0){
                maxi=i+1;
            }
            else{
                if(M.containsKey(prefixsum)){
                    maxi=Math.max(maxi,i-M.getOrDefault(prefixsum,0));
                }
                else{
                    M.put(prefixsum,i);
                }
            }
        }
        return maxi;
    }
}