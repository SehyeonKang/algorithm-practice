package inflearn.chap5;

import java.util.Scanner;
import java.util.Stack;

public class No_3 {
    public int solution(int n, int[][] board, int m, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < m; i++) {
            int num = moves[i];
            int row = 0;

            while (board[row][num] == 0) {
                row++;
                if (row == n)
                    break;
            }

            if (row == n)
                continue;

            if (!stack.isEmpty() && stack.peek() == board[row][num]) {
                answer += 2;
                stack.pop();
            } else
                stack.push(board[row][num]);

            board[row][num] = 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        No_3 T = new No_3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n + 1; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, board, m, moves));
    }
}
