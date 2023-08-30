package inflearn.chap6;

import java.util.Arrays;
import java.util.Scanner;

public class No_9 {
    public int count(int capacity, int[] arr) {
        int sum = 0;
        int count = 1;

        for (int x : arr) {
            if (sum + x > capacity) {
                count++;
                sum = x;
            } else
                sum += x;
        }

        return count;
    }

    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int start = Arrays.stream(arr).max().getAsInt();
        int end = Arrays.stream(arr).sum();

        while (end >= start) {
            int mid = (start + end) / 2;
            if (count(mid, arr) <= m) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
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
