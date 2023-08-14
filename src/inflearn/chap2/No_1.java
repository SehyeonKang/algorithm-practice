package inflearn.chap2;

import java.util.Scanner;

public class No_1 {
    public String solution(int arr[]) {
        String answer = "";

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                answer += arr[i] + " ";
            } else {
                if (arr[i] > arr[i - 1]) {
                    answer += arr[i] + " ";
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        No_1 T = new No_1();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(arr));
    }
}
