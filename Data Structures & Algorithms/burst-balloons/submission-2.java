class Solution {
    int dp[][];
    public int maxCoins(int[] nums) {
       int n = nums.length;
       dp = new int[n+2][n+2];

for(int row[] : dp) {
    Arrays.fill(row, -1);
}

        // Changed: Create array with two extra boundary positions
        int arr[] = new int[n+2];

        // Changed: Add boundary balloons
        arr[0] = 1;
        arr[n+1] = 1;

        // Changed: Copy original balloons
        for(int i=0; i<n; i++) {
            arr[i+1] = nums[i];
        }

        return solve(arr, 1, n);
    }
    public int solve(int arr[], int i, int j) {

        // Base condition
        if(i > j) {
            return 0;
        }
        if(dp[i][j] != -1) {
    return dp[i][j];
}

        int max = Integer.MIN_VALUE;

        // Partition
        for(int k = i; k <= j; k++) {

            int left = solve(arr, i, k-1);

            int right = solve(arr, k+1, j);

            int temp = left + right
                     + arr[i-1] * arr[k] * arr[j+1];

            max = Math.max(max, temp);
        }

        return dp[i][j]=max;
    }
}
