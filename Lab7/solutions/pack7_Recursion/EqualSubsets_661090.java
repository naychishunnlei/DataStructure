package solutions.pack7_Recursion;

import java.util.Arrays;

public class EqualSubsets_661090 {

    // Check if a set can be partitioned into two subsets with equal sum using recursion
    public static boolean canPartition_Recur(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        // If the sum is odd, it cannot be divided into two equal subsets
        if (sum % 2 != 0) return false;
        return canPartitionHelper(arr, sum / 2, 0);
    }

    private static boolean canPartitionHelper(int[] arr, int target, int index) {
        if (target == 0) return true;
        if (index >= arr.length || target < 0) return false;
        
        // Include the current element and check if we can partition the remaining target with remaining elements
        if (canPartitionHelper(arr, target - arr[index], index + 1)) return true;
        // Exclude the current element and check the rest of the array
        return canPartitionHelper(arr, target, index + 1);
    }

    // Check if a set can be partitioned into two subsets with equal sum using memoization
    public static boolean canPartition_Memoiz(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        // If the sum is odd, it cannot be divided into two equal subsets
        if (sum % 2 != 0) return false;
        
        int target = sum / 2;
        Boolean[][] memo = new Boolean[arr.length][target + 1];
        return canPartitionHelperMemo(arr, target, 0, memo);
    }

    private static boolean canPartitionHelperMemo(int[] arr, int target, int index, Boolean[][] memo) {
        if (target == 0) return true;
        if (index >= arr.length || target < 0) return false;
        if (memo[index][target] != null) return memo[index][target];
        
        // Include the current element
        boolean include = canPartitionHelperMemo(arr, target - arr[index], index + 1, memo);
        // Exclude the current element
        boolean exclude = canPartitionHelperMemo(arr, target, index + 1, memo);
        
        memo[index][target] = include || exclude;
        return memo[index][target];
    }

    // Check if a set can be partitioned into two subsets with equal sum using dynamic programming
    public static boolean canPartition_DP(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        // If the sum is odd, it cannot be divided into two equal subsets
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;  // There's always a way to get a sum of 0 - by taking no elements

        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }
}
