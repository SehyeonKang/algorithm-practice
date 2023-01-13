package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_9663 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int result = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        // 1~N열의 체스판, 각 열의 원소는 행
        arr = new int[N];

        dfs(0);

        System.out.println(result);

    }

    private static void dfs(int depth) {

        if (depth == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (queenCheck(depth))
                dfs(depth + 1);
        }
    }

    private static boolean queenCheck(int check) {

        for (int i = 0; i < check; i++) {

            // 같은 행에 퀸이 있을 경우
            if (arr[check] == arr[i]) {
                return false;
            }

            // 대각선에 퀸이 있을 경우
            else if (Math.abs(arr[check] - arr[i]) == Math.abs(check - i))
                return false;
        }

        return true;
    }
}
