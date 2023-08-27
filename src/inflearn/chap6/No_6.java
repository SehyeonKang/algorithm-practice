package inflearn.chap6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class No_6 {
    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = arr.clone();
        for (int i = 0; i < n; i++) {
            tmp[i] = arr[i];
        }
        Arrays.sort(tmp);

        for (int i = 0; i < n; i++) {
            if (arr[i] != tmp[i])
                answer.add(i + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        No_6 T = new No_6();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> answer = T.solution(n, arr);

        for (int x : answer) {
            System.out.print(x + " ");
        }
    }
}
