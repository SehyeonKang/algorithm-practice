package inflearn.chap2;

import java.util.Scanner;

public class No_2 {
    public int solution(int n, int[] arr) {
        int answer = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        No_2 T = new No_2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}
