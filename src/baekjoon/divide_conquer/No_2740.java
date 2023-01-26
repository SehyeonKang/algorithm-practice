package baekjoon.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2740 {

    static int[][] matA, matB, matC;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int rowA = Integer.parseInt(st.nextToken());
        int colA = Integer.parseInt(st.nextToken());
        matA = new int[rowA][colA];

        for (int i = 0; i < rowA; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < colA; j++) {
                matA[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int rowB = Integer.parseInt(st.nextToken());
        int colB = Integer.parseInt(st.nextToken());
        matB = new int[rowB][colB];
        matC = new int[rowA][colB];

        for (int i = 0; i < rowB; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < colB; j++) {
                matB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                for (int k = 0; k < colA; k++) {
                    matC[i][j] += matA[i][k] * matB[k][j];
                }
            }
        }

        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                if (j != colB - 1) {
                    sb.append(matC[i][j] + " ");
                } else
                    sb.append(matC[i][j] + "\n");
            }
        }

        System.out.println(sb);
    }
}
