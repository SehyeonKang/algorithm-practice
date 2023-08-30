package inflearn.chap8;

import java.util.Scanner;

public class No_7 {
    static int[][] memo;

    public int dfs(int n, int r) {
        if (memo[n][r] > 0)
            return memo[n][r];

        if (r == 1 || n - r == 1)
            return n;

        memo[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
        return memo[n][r];
    }

    public static void main(String[] args) {
        No_7 T = new No_7();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        memo = new int[n + 1][r + 1];
        int answer = T.dfs(n, r);
        System.out.println(answer);
    }
}
