package inflearn.chap3;

import java.util.Scanner;

public class No_3 {
    public int solution(int n, int k, int[] arr) {
        int answer;
        int p1 = 0;
        int p2 = k;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int max = sum;

        while (p2 < n) {
            sum = sum - arr[p1++] + arr[p2++];
            max = Math.max(max, sum);
        }

        answer = max;
        return answer;
    }

    public static void main(String[] args) {
        No_3 T = new No_3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, k, arr));
    }
}
