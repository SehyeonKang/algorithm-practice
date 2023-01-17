package baekjoon.dinamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1463 {

    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new Integer[N + 1];

        dp[1] = 0;
        int result = calculate(N);
        System.out.println(result);
    }

    private static int calculate(int n) {

        if (dp[n] == null) {
            if (n % 3 == 0) {
                if (n % 2 == 0) {
                    dp[n] = Math.min(Math.min(calculate(n / 3), calculate(n / 2)), calculate(n - 1)) + 1;
                } else {
                    dp[n] = Math.min(calculate(n / 3), calculate(n - 1)) + 1;
                }
            } else if (n % 2 == 0) {
                dp[n] = Math.min(calculate(n / 2), calculate(n - 1)) + 1;
            } else
                dp[n] = calculate(n - 1) + 1;
        }

        return dp[n];
    }
}
