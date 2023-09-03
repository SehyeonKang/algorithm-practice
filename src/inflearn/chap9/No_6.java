package inflearn.chap9;

import java.util.Scanner;

public class No_6 {

    static int[] unf;

    public int find(int n) {
        if (unf[n] == n) {
            return unf[n];
        } else {
            unf[n] = find(unf[n]);
            return unf[n];
        }

    }

    public void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb)
            unf[fa] = fb;
    }

    public static void main(String[] args) {
        No_6 T = new No_6();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unf = new int[n + 1];
        for (int i = 1; i < n; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            T.union(a, b);
        }

        int fa = T.find(sc.nextInt());
        int fb = T.find(sc.nextInt());
        if (fa == fb) {
            System.out.println("YES");
        } else
            System.out.println("NO");
    }
}
