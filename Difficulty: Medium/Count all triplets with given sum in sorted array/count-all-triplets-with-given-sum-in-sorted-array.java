//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(sc.nextLine());

            Solution ob = new Solution();
            int ans = ob.countTriplets(arr, target);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends





class Solution {
    public int countTriplets(int[] arr, int target) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];

                if (sum == target) {
                    if (arr[j] == arr[k]) {
                        // If all elements between j and k are the same
                        int freq = k - j + 1;
                        count += (freq * (freq - 1)) / 2; // nC2 combinations
                        break;
                    } else {
                        int leftCount = 1, rightCount = 1;

                        // Count duplicates for j
                        while (j + 1 < k && arr[j] == arr[j + 1]) {
                            leftCount++;
                            j++;
                        }

                        // Count duplicates for k
                        while (k - 1 > j && arr[k] == arr[k - 1]) {
                            rightCount++;
                            k--;
                        }

                        // Add all combinations
                        count += leftCount * rightCount;
                        j++;
                        k--;
                    }
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return count;
    }

}