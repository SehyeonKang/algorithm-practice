package inflearn.chap6;

import java.util.Arrays;
import java.util.Scanner;

public class No_8 {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = 0;
        int rt = n - 1;
        int p = (lt + rt) / 2;
        Arrays.sort(arr);

        while (rt - lt >= 0) {
            if (arr[p] == m) {
                answer = p + 1;
                break;
            } else if (arr[p] < m) {
                lt = p + 1;
            } else {
                rt = p - 1;
            }
            p = (lt + rt) / 2;
        }

        return answer;
    }

    public static void main(String[] args) {
        No_8 T = new No_8();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, m, arr));
    }
}
