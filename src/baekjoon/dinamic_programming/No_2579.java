package baekjoon.dinamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2579 {

    static int[] stairs;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        stairs = new int[n + 1];
        dp = new Integer[n + 1];

        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = stairs[0];
        dp[1] = stairs[1];

        if (n >= 2)
            dp[2] = stairs[1] + stairs[2];

        System.out.println(score(n));

    }

    private static int score(int n) {

        if (dp[n] == null) {
            dp[n] = Math.max(score(n - 3) + stairs[n - 1], score(n - 2)) + stairs[n];
        }

        return dp[n];
    }
}
