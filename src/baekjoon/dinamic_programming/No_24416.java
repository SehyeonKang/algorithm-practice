package baekjoon.dinamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_24416 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int code1 = 0;
    static int code2 = 0;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        fibonacci1(n);
        fibonacci2(n);

        System.out.println(code1 + " " + code2);
    }

    private static int fibonacci1(int n) {

        if (n == 1 || n == 2) {
            code1++;
            return 1;
        }

        return (fibonacci1(n - 1) + fibonacci1(n - 2));
    }

    private static int fibonacci2(int n) {
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 1;

        for (int i = 3; i < n + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
            code2++;
        }

        return arr[n];
    }
}
