package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_14888 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static long max, min;
    static int[] arr, calc;
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        calc = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            calc[i] = Integer.parseInt(st.nextToken());
        }

        max = Long.MIN_VALUE;
        min = Long.MAX_VALUE;

        dfs(0, 0);

        System.out.println(max + "\n" + min);
    }

    private static void dfs(long result, int depth) {

        if (calc[0] == 0 && calc[1] == 0 && calc[2] == 0 && calc[3] == 0) {

            if (result > max)
                max = result;

            if (result < min)
                min = result;

            return;
        }

        if (depth == 0) {
            dfs(arr[0], depth + 1);
        } else {
            for (int i = 0; i < 4; i++) {
                if (calc[i] != 0) {
                    calc[i]--;
                    long calcResult = calculation(result, depth, i);
                    dfs(calcResult, depth + 1);
                    calc[i]++;
                }
            }
        }
    }

    private static long calculation(long num, int depth, int calc) {

        long result;

        if (calc == 0) {
            result = num + arr[depth];
        } else if (calc == 1) {
            result = num - arr[depth];
        } else if (calc == 2) {
            result = num * arr[depth];
        } else {
            if (num < 0) {
                num *= -1;
                result = (num / arr[depth]) * -1;
            } else
                result = num / arr[depth];
        }

        return result;
    }
}
