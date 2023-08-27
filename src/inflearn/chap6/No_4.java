package inflearn.chap6;

import java.util.Scanner;

public class No_4 {
    public int[] solution(int s, int n, int[] work) {
        int[] answer = new int[s];
        int[] check = new int[101];

        for (int i = 0; i < n; i++) {
            if (check[work[i]] == 0) {
                if (answer[0] > 0) {
                    check[answer[s - 1]] = 0;
                    for (int j = s - 1; j > 0; j--) {
                        answer[j] = answer[j - 1];
                    }
                    answer[0] = work[i];
                    check[answer[0]] = 1;
                } else {
                    int count = 0;
                    while (count < s && answer[count] == 0) {
                        count++;
                    }
                    answer[count - 1] = work[i];
                    check[answer[count - 1]] = 1;
                }
            } else {
                int index = 0;
                for (int j = 0; j < s; j++) {
                    if (answer[j] == work[i]) {
                        index = j;
                    }
                }

                for (int j = index; j > 0; j--) {
                    int tmp = answer[j - 1];
                    answer[j - 1] = answer[j];
                    answer[j] = tmp;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        No_4 T = new No_4();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] work = new int[n];
        for (int i = 0; i < n; i++) {
            work[i] = sc.nextInt();
        }

        int[] solution = T.solution(s, n, work);
        for (int x : solution) {
            System.out.print(x + " ");
        }
    }
}
