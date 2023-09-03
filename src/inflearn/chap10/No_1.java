package inflearn.chap10;

import java.util.Scanner;

public class No_1 {

    static int[] dp;

    public int recur(int n) {
        if (dp[n] > 0)
            return dp[n];

        if (n < 3) {
            dp[n] = n;
            return dp[n];
        }

        dp[n] = recur(n - 1) + recur(n - 2);
        return dp[n];
    }

    public static void main(String[] args) {
        No_1 T = new No_1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n + 1];
        System.out.println(T.recur(n));
    }
}
