//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends
// User function Template for Java

// User function Template for Java

class Solution {

    static int sameOccurrence(int arr[], int x, int y) {
        // HashMap to store the count difference frequencies
        HashMap<Integer, Integer> map = new HashMap<>();
        int diffCount = 0; // Difference between count(x) and count(y)
        int count = 0;     // Total count of valid subarrays

        // Initialize with diffCount 0, which means we have equal x and y count from the start
        map.put(0, 1);

        for (int num : arr) {
            // Update diffCount based on encountering x or y
            if (num == x) {
                diffCount++;
            } else if (num == y) {
                diffCount--;
            }

            // If diffCount has been seen before, there exists a subarray
            // from previous occurrence to current index with equal count of x and y
            if (map.containsKey(diffCount)) {
                count += map.get(diffCount);
            }

            // Add/update the frequency of the current diffCount in the map
            map.put(diffCount, map.getOrDefault(diffCount, 0) + 1);
        }

        return count;
    }
}

//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.sameOccurrence(arr, x, y);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends