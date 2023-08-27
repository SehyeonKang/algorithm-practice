package inflearn.chap6;

import java.util.Scanner;

public class No_3 {
    public int[] solution(int n, int[] arr) {

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[j + 1])
                    break;

                int tmp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = tmp;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        No_3 T = new No_3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] answer = T.solution(n, arr);

        for (int x : answer) {
            System.out.print(x + " ");
        }
    }
}
