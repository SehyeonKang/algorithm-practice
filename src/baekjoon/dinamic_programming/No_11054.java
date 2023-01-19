package baekjoon.dinamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_11054 {

    static final int LEFT = 0;
    static final int RIGHT = 1;
    static int N;
    static int[] arr;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new Integer[N][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            recur(i, LEFT);
        }

        for (int i = N - 1; i >= 0; i--) {
            recur(i, RIGHT);
        }

        int max = 0;
        for (int i = 0; i < N; i++) {

            if (max < dp[i][0] + dp[i][1] - 1)
                max = dp[i][0] + dp[i][1] - 1;
        }

        System.out.println(max);
    }

    private static int recur(int n, int vector) {

        if (dp[n][vector] == null) {
            dp[n][vector] = 1;

            if (vector == 0) {
                for (int i = n - 1; i >= 0; i--) {
                    if (arr[n] > arr[i])
                        dp[n][vector] = Math.max(dp[n][vector], recur(i, vector) + 1);
                }
            } else {
                for (int i = n + 1; i < N; i++) {
                    if (arr[n] > arr[i])
                        dp[n][vector] = Math.max(dp[n][vector], recur(i, vector) + 1);
                }
            }
        }

        return dp[n][vector];
    }
}
