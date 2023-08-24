package inflearn.chap2;

import inflearn.Main;

import java.util.Scanner;

public class No_7 {
    public int solution(int n, int[] arr) {
        int answer = 0;
        int score = 1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                answer += score;
                score++;
            } else
                score = 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        No_7 T = new No_7();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}
