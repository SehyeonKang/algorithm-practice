package inflearn.chap6;

import java.util.Scanner;

public class No_5 {
    public String solution(int n, int[] arr) {
        String answer = "U";
        boolean[] check = new boolean[100001];

        for (int x : arr) {
            if (check[x])
                return "D";

            check[x] = true;
        }

        return answer;
    }

    public static void main(String[] args) {
        No_5 T = new No_5();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}
