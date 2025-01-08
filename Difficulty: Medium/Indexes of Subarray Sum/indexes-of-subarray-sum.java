//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int d = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            ArrayList<Integer> result = ob.subarraySum(nums, d);
            // Print all elements in the result list
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println(); // Print a new line after the result
            System.out.println("~");
        }
    }
}

// } Driver Code Ends






class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int flag = 0;
        while(j < arr.length){
            sum += arr[j];
            while(sum > target){
                sum -= arr[i];
                i++;
            }
            if(sum == target){
                flag = 1;
                break;
            }
            j++;
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        if(flag == 0){
            ans.add(-1);
            return ans;
        }
        ans.add(i+1);
        ans.add(j+1);
        return ans;
    }
}