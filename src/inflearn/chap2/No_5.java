package inflearn.chap2;

import java.util.Scanner;

public class No_5 {
    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                for (int j = i; j <= n; j += i)
                    arr[j] = 1;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        No_5 T = new No_5();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(T.solution(n));
    }
}
