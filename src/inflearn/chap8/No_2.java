package inflearn.chap8;

import java.util.Scanner;

public class No_2 {
    static int c;
    static int n;
    static int[] arr;
    static boolean check;
    static int sum = 0;
    static int answer = Integer.MIN_VALUE;

    public void dfs(int num) {
        if (check)
            return;

        if (sum > c)
            return;

        if (num == n && sum < c) {
            answer = Math.max(answer, sum);
            if (sum == c)
                check = true;

            return;
        }

        sum += arr[num];
        dfs(num + 1);
        sum -= arr[num];
        dfs(num + 1);
    }

    public static void main(String[] args) {
        No_2 T = new No_2();
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        T.dfs(1);
        sum += arr[0];
        T.dfs(1);

        System.out.println(answer);
    }
}