package inflearn.chap8;

import java.util.Scanner;

public class No_9 {
    static int n, m;
    static int[] arr;

    public void dfs(int L, int s) {
        if (L == m) {
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = s; i <= n; i++) {
                arr[L] = i;
                dfs(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        No_9 T = new No_9();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        T.dfs(0, 1);
    }
}
