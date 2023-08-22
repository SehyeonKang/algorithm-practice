package inflearn.chap2;

import inflearn.Main;

import java.util.Scanner;

public class No_4 {
    public int[] solution(int n) {
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;

        for (int i = 2; i < n; i++) {
            answer[i] = answer[i - 1] + answer[i - 2];
        }

        return answer;
    }

    public static void main(String[] args) {
        No_4 T = new No_4();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] solution = T.solution(n);

        for (int x : solution) {
            System.out.print(x + " ");
        }
    }
}
