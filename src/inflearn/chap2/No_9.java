package inflearn.chap2;

import inflearn.Main;

import java.util.Scanner;

public class No_9 {
    public int solution(int n, int[][] arr) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            int colSum = 0;

            for (int j = 0; j < n; j++) {
                rowSum += arr[i][j];
                colSum += arr[j][i];
            }

            if (answer < Math.max(rowSum, colSum)) {
                answer = Math.max(rowSum, colSum);
            }
        }

        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][n - i - 1];
        }

        if (answer < Math.max(sum1, sum2))
            answer = Math.max(sum1, sum2);

        return answer;
    }

    public static void main(String[] args) {
        No_9 T = new No_9();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(T.solution(n, arr));
    }
}
