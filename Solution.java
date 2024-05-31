public class Solution {
    public static boolean solve(int p, int a, int b, int[] enemies) {
        int n = enemies.length;
        int[][] dp = new int[n + 1][a + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= a; j++) {
                dp[i][j] = -1;

            }
        }
        dp[0][0] = b;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= a; j++) {
                if (dp[i][j] == -1)
                    continue;

                int energy = p + dp[i][j] * (p - enemies[i]);
                if (energy >= enemies[i]) {
                    if (i + 1 == 3 || i + 1 == 7) {
                        if (dp[i][j] > 0) {
                            dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] - 1);
                        }
                    }
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
                }
                if (j < a) {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j]);
                }
            }
        }

        for (int j = 0; j <= a; j++) {
            if (dp[n][j] >= 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] k1 = { 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120 };
        int[] k2 = { 3, 5, 2, 9, 4, 8, 6, 7, 4, 3, 2 };
        int[] k3 = { 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150 };
        boolean testCase1 = solve(100, 2, 1, k1);
        System.out.println("Test Case 1: " + testCase1);

        boolean testCase2 = solve(10, 3, 5, k2);
        System.out.println("Test Case 2: " + testCase2);
        boolean testCase3 = solve(100, 2, 1, k3);
        System.out.println("Test Case 3: " + testCase3);
        boolean testCase4 = solve(100, 1, 1, k1);
        System.out.println("Test Case 4: " + testCase4);
    }
}
