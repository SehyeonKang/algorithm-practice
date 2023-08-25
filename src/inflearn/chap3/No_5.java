package inflearn.chap3;

import java.util.Scanner;

public class No_5 {
    public int solution(int n) {
        int answer = 0;
        int lt = 1;
        int sum = 0;

        for (int rt = 1; rt <= n / 2 + 1; rt++) {
            sum += rt;
            if (sum == n)
                answer++;

            while (sum >= n) {
                sum -= lt++;
                if (sum == n)
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
