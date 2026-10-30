class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        int n = s.length();
        int n1 = wordDict.size();

        boolean dp[][] = new boolean[n + 1][n1 + 1];

        // Entire string consumed
        for (int j = 0; j <= n1; j++) {
            dp[n][j] = true;
        }

        // Fill backwards
        for (int i = n - 1; i >= 0; i--) {

            for (int j = n1 - 1; j >= 0; j--) {

                String word = wordDict.get(j);

                boolean include = false;

                if (s.startsWith(word, i)) {
                    include = dp[i + word.length()][0];
                }

                boolean exclude = dp[i][j + 1];

                dp[i][j] = include || exclude;
            }
        }

        return dp[0][0];
    }
}