package baekjoon.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_11444 {

    static final int MOD = 1000000007;
    static long[][] origin = {{1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[][] matA = {{1, 1}, {1, 0}};
        long n = Long.parseLong(br.readLine());

        System.out.println(pow(matA, n - 1)[0][0]);

    }

    private static long[][] pow(long[][] matA, long exp) {

        if (exp < 2)
            return matA;

        long[][] tmp = pow(matA, exp / 2);

        tmp = multiply(tmp, tmp);

        if (exp % 2 == 1L)
            tmp = multiply(tmp, origin);

        return tmp;
    }

    private static long[][] multiply(long[][] mat1, long[][] mat2) {

        long[][] tmp = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    tmp[i][j] += mat1[i][k] * mat2[k][j];
                    tmp[i][j] %= MOD;
                }
            }
        }

        return tmp;
    }
}
