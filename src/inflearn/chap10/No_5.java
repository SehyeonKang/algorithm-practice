package inflearn.chap10;

import java.util.Arrays;
import java.util.Scanner;

public class No_5 {

    static int[] dp;

    public int solution(int[] arr, int m) {
        int answer = 0;
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j <= m; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }
        answer = dp[m];

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
        int m = sc.nextInt();
        dp = new int[m + 1];
        System.out.println(T.solution(arr, m));
    }
}
