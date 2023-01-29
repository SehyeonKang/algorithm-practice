package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No_1920 {

    static StringBuilder sb = new StringBuilder();
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            recur(0, N - 1, num);
        }

        System.out.println(sb);
    }

    private static void recur(int lo, int hi, int num) {

        if (lo + 1 == hi) {
            if (A[lo] == num || A[hi] == num) {
                sb.append(1 + "\n");
            } else
                sb.append(0 + "\n");

            return;
        }

        int mid = (lo + hi) / 2;

        if (num >= A[mid]) {
            recur(mid, hi, num);
        } else
            recur(lo, mid, num);
    }
}
