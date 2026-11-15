class Solution {

    int[][] dirx = {
        {0, -1}, {0, 1}, {1, 0}, {-1, 0}
    };

    public int longestIncreasingPath(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] t = new int[m][n];
        Queue<int[]> q = new LinkedList<>();

        // Count greater neighbours and add local maxima to queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] dir : dirx) {
                    int x = i + dir[0];
                    int y = j + dir[1];

                    if (x >= 0 && y >= 0 && x < m && y < n
                            && matrix[x][y] > matrix[i][j]) {
                        t[i][j]++;
                    }
                }

                if (t[i][j] == 0) q.offer(new int[]{i, j});
            }
        }

        int max = 0;

        // Process cells level by level
        while (!q.isEmpty()) {
            int size = q.size();
            max++;

            while (size-- > 0) {
                int[] curr = q.poll();
                int i = curr[0], j = curr[1];

                for (int[] dir : dirx) {
                    int x = i + dir[0];
                    int y = j + dir[1];

                    if (x >= 0 && y >= 0 && x < m && y < n
                            && matrix[x][y] < matrix[i][j]) {

                        if (--t[x][y] == 0) {
                            q.offer(new int[]{x, y});
                        }
                    }
                }
            }
        }

        return max;
    }
}