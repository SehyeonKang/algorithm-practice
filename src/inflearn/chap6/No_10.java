package inflearn.chap6;

import java.util.Arrays;
import java.util.Scanner;

public class No_10 {
    public int count(int dist, int[] arr) {
        int count = 1;
        int ep = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - ep >= dist) {
                ep = arr[i];
                count++;
            }
        }

        return count;
    }

    public int solution(int n, int c, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt = arr[1] - arr[0];
        int rt = arr[n - 1];

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (count(mid, arr) >= c) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        No_10 T = new No_10();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, c, arr));
    }
}
