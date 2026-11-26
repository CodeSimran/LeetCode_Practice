class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int n : nums) totalSum += n;

        // If total sum is odd, we can't partition it into two equal subsets
        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;
        int n = nums.length;

        // dp[i][j] means whether sum j can be achieved using first i elements
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base case: sum 0 is always possible
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] <= j) {
                    // Two choices: pick the current element or don't pick it
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    // Current element is too big, must skip it
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][target];
    }
}