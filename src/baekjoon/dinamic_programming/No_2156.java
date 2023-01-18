package baekjoon.dinamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2156 {

    static Integer[] dp;
    static int[] glass;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new Integer[n + 1];
        glass = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            glass[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = glass[0];
        dp[1] = glass[1];

        if (n >= 2) {
            dp[2] = glass[1] + glass[2];
            dp[2] = glass[1] + glass[2];
        }

        System.out.println(recur(n));
    }

    private static int recur(int n) {

        if (dp[n] == null)
            dp[n] = Math.max(Math.max(recur(n - 2), recur(n - 3) + glass[n - 1]) + glass[n], recur(n - 1));

        return dp[n];
    }
}
