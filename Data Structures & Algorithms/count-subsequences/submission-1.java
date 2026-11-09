class Solution {

    int[][] t;

    public int numDistinct(String s, String t1) {
        int m = s.length();
        int n = t1.length();

        t = new int[m + 1][n + 1];

        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        return lcsHelper(s, t1, m, n);
    }

    public int lcsHelper(String s1, String s2, int m, int n) {

        if (n == 0) {
            return 1;
        }

        if (m == 0) {
            return 0;
        }

        if (t[m][n] != -1) {
            return t[m][n];
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {

            return t[m][n] =
                lcsHelper(s1, s2, m - 1, n - 1)
                + lcsHelper(s1, s2, m - 1, n);
        }

        return t[m][n] =
            lcsHelper(s1, s2, m - 1, n);
    }
}