package baekjoon.dinamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_11053 {

    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            recur(i);
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < dp[i])
                max = dp[i];
        }

        System.out.println(max);
    }

    private static int recur(int n) {

        if (dp[n] == null) {
            dp[n] = 1;

            for (int i = n - 1; i >= 0; i--) {
                if (arr[n] > arr[i]) {
                    dp[n] = Math.max(dp[n], recur(i) + 1);
                }
            }
        }

        return dp[n];
    }
}
