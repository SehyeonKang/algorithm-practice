package inflearn.chap10;

import java.util.Scanner;

public class No_2 {

    static int[] dp;

    public int recur(int n) {
        if (dp[n] > 0)
            return dp[n];

        if (n < 3)
            return dp[n] = n;

        return dp[n] = recur(n - 1) + recur(n - 2);
    }

    public static void main(String[] args) {
        No_2 T = new No_2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n + 2];
        System.out.println(T.recur(n + 1));
    }
}
