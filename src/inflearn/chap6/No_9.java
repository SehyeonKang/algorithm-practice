package inflearn.chap6;

import java.util.Arrays;
import java.util.Scanner;

public class No_9 {
    public boolean count(int n, int size, int[] arr) {
        for (int i = n - 1; i >= 0; i--) {

        }
    }

    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int sum = 0;
        int start = 0;
        int end;
        int mid;
        Arrays.sort(arr);

        for (int x : arr) {
            sum += x;
        }
        end = sum;
        mid = (start + end) / 2;

        int min = Integer.MAX_VALUE;
        while (end - start >= 0) {
            if ()
        }


        return answer;
    }

    public static void main(String[] args) {
        No_9 T = new No_9();
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
