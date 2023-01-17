package baekjoon.dinamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1932 {

    static int[][] triangle;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        triangle = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        dp[0][0] = triangle[0][0];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int result = calculate(n - 1, i);

            if (result > max)
                max = result;
        }

        System.out.println(max);

    }

    public static int calculate(int n, int m) {

        if (dp[n][m] == -1) {
            if (m == 0) {
                dp[n][m] = calculate(n - 1, m) + triangle[n][m];
            } else if (n == m) {
                dp[n][m] = calculate(n - 1, m - 1) + triangle[n][m];
            } else
                dp[n][m] = Math.max(calculate(n - 1, m - 1), calculate(n - 1, m)) + triangle[n][m];
        }

        return dp[n][m];
    }
}
