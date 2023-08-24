package inflearn.chap2;

import inflearn.Main;

import java.util.Scanner;

public class No_8 {
    public int[] solution(int n, int[] arr) {
        int[] answer = new int[n];
        int cnt = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i] < arr[j]) {
                    cnt++;
                }
            }
            answer[i] = cnt;
            cnt = 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        No_8 T = new No_8();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] answer= T.solution(n, arr);
        for (int x : answer) {
            System.out.print(x + " ");
        }
    }
}
