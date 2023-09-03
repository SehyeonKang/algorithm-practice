package inflearn.chap10;

import java.util.Scanner;

public class No_3 {

    static int n;
    static int[] dp;

    public int solution(int[] arr) {
        int answer = 1;
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (max < dp[j] && arr[j] < arr[i])
                    max = dp[j];
            }

            dp[i] = max + 1;
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        No_3 T = new No_3();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(arr));
    }
}
