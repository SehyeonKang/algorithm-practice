package baekjoon.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1629 {

    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        long result = recur(A, B);
        System.out.println(result);
    }

    private static long recur(int a, int b) {

        if (b == 1)
            return a % C;

        long tmp = recur(a, b / 2);

        if (b % 2 == 1) {
            return (tmp * tmp % C) * a % C;
        }

        return tmp * tmp % C;
    }
}
