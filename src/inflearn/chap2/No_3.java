package inflearn.chap2;

import inflearn.Main;

import java.util.Scanner;

public class No_3 {
    public String[] solution(int n, int[] arrA, int[] arrB) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            if (arrA[i] == arrB[i]) {
                answer[i] = "D";
            } else if ((arrA[i] == 1 && arrB[i] == 3)
                    || (arrA[i] == 2 && arrB[i] == 1)
                    || (arrA[i] == 3 && arrB[i] == 2)) {
                answer[i] = "A";
            } else
                answer[i] = "B";
        }

        return answer;
    }

    public static void main(String[] args) {
        No_3 T = new No_3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrA = new int[n];
        int[] arrB = new int[n];

        for (int i = 0; i < n; i++) {
            arrA[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arrB[i] = sc.nextInt();
        }

        String[] solution = T.solution(n, arrA, arrB);

        for (int i = 0; i < n; i++) {
            System.out.println(solution[i]);
        }
    }
}
