//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int target = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            List<Integer> res = ob.sumClosest(arr, target);
            if (res.isEmpty()) {
                System.out.print("[]");
            } else {
                for (Integer num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java



// User function Template for Java

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
        List<Integer>list=new ArrayList<>();
        Arrays.sort(arr);
        int start=0,last=arr.length-1;
        int mini=Integer.MAX_VALUE;
        while(start<last){
            int sum=arr[start]+arr[last];
            if(Math.abs(target-sum)<mini){
                mini=Math.min(Math.abs(target-sum),mini);
                list.clear();
                list.add(arr[start]);
                list.add(arr[last]);
                // new ArrayList<>(arr[start],arr[last]);
            }
            if(sum<target) start++;
            else if(sum>target) last--;
            else return list;
            
               
        }
        return list;
    }
}