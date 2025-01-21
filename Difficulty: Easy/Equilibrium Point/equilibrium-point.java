//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(
                    token)); // Use Integer.parseInt to parse int values
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            Solution obj = new Solution();

            // calling equilibriumPoint() function
            System.out.println(obj.findEquilibrium(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        int total = 0;
        
        // Calculate the total sum of the array elements
        for (int a : arr) {
            total += a;
        }

        int leftsum = 0;

        // Iterate through the array to find the equilibrium point
        for (int left = 0; left < arr.length; left++) {
            total -= arr[left];  // Update total to be the right sum for current index

            // If left sum equals right sum, equilibrium is found
            if (leftsum == total) {
                return left;  // Return 1-based index
            }

            leftsum += arr[left];  // Update left sum
        }

        // Return -1 if no equilibrium point is found
        return -1;
    }
}