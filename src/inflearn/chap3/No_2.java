package inflearn.chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class No_2 {
    public ArrayList<Integer> solution(int n, int m, int[] arrA, int[]arrB) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;

        while (p1 < n && p2 < m) {
            if (arrA[p1] == arrB[p2]) {
                answer.add(arrA[p1++]);
                p2++;
            } else if (arrA[p1] < arrB[p2]) {
                p1++;
            } else
                p2++;
        }

        return answer;
    }

    public static void main(String[] args) {
        No_2 T = new No_2();
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

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        ArrayList<Integer> answer = T.solution(n, m, arrA, arrB);

        for (int x : answer) {
            System.out.print(x + " ");
        }
    }
}
