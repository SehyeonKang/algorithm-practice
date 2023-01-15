package baekjoon.dinamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_9461 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            long result = dp(N);
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static long dp(int n) {
        long[] arr = new long[n + 5];

        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;

        for (int i = 6; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 5];
        }

        return arr[n];
    }
}
