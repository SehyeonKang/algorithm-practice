package inflearn.chap3;

import java.util.ArrayList;
import java.util.Scanner;

public class No_1 {
    public ArrayList<Integer> solution(int[] arrA, int[] arrB) {
        ArrayList<Integer> answer = new ArrayList<>();
        int pa = 0;
        int pb = 0;

        while (pa < arrA.length && pb < arrB.length) {
            if (arrA[pa] < arrB[pb]) {
                answer.add(arrA[pa++]);
            } else
                answer.add(arrB[pb++]);
        }

        while (pa < arrA.length) {
            answer.add(arrA[pa++]);
        }

        while (pb < arrB.length) {
            answer.add(arrB[pb++]);
        }

        return answer;
    }

    public static void main(String[] args) {
        No_1 T = new No_1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrA = new int[n];
        for (int i = 0; i < n; i++) {
            arrA[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arrB = new int[m];
        for (int i = 0; i < m; i++) {
            arrB[i] = sc.nextInt();
        }

        ArrayList<Integer> answer = T.solution(arrA, arrB);

        for (int x : answer) {
            System.out.print(x + " ");
        }
    }
}
