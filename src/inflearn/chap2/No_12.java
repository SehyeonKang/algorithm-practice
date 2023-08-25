package inflearn.chap2;

import inflearn.Main;

import java.util.Scanner;

public class No_12 {
    public int solution(int n, int m, int[][] arr) {
        int answer = 0;

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                int mentor = arr[0][i];
                int mentee = arr[0][j];
                boolean check = true;

                for (int k = 1; k < m; k++) {
                    for (int l = 1; l < n + 1; l++) {
                        if (arr[k][l] == mentor) {
                            break;
                        } else if (arr[k][l] == mentee) {
                            check = false;
                            break;
                        }
                    }
                    if (!check)
                        break;
                }

                if (check)
                    answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        No_12 T = new No_12();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(T.solution(n, m, arr));
    }
}
