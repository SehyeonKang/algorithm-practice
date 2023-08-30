package inflearn.chap8;

import java.util.Scanner;

public class No_8 {
    static int[] b, p, ch;
    static int n, f;
    boolean flag = false;
    static int[][] dp;

    public int combi(int n, int r) {
        if (dp[n][r] > 0)
            return dp[n][r];

        if (n == r || r == 0)
            return 1;

        return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }

    public void dfs(int L, int sum) {
        if (flag)
            return;

        if (L == n) {
            if (sum == f) {
                for (int x : p) {
                    System.out.print(x + " ");
                }
                flag = true;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    p[L] = i;
                    dfs(L + 1, sum + p[L] * b[L]);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        No_8 T = new No_8();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();
        b = new int[n];
        p = new int[n];
        ch = new int[n + 1];
        dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            b[i] = T.combi(n - 1, i);
        }
        T.dfs(0, 0);
    }
}
