package baekjoon.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_10830 {

    static int[][] matA;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        matA = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matA[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] matAns = recur(matA, B);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(matAns[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int[][] recur(int[][] mat, long b) {

        if (b == 1L)
            return mat;

        int[][] tmp = recur(mat, b / 2);

        tmp = multiply(tmp, tmp);

        if (b % 2 == 1L) {
            tmp = multiply(tmp, matA);
        }

        return tmp;
    }

    private static int[][] multiply(int[][] mat1, int[][] mat2) {

        int[][] tmp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    tmp[i][j] += mat1[i][k] * mat2[k][j];
                    tmp[i][j] %= 1000;
                }
            }
        }

        return tmp;

    }
}
