package inflearn.chap4;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class No_5 {
    public int solution(int n, int k, int[] arr) {
        int answer = -1;
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    set.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        int count = 0;
        for (int x : set) {
            count++;
            if (count == k)
                return x;
        }

        return answer;
    }

    public static void main(String[] args) {
        No_5 T = new No_5();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, k, arr));
    }
}
