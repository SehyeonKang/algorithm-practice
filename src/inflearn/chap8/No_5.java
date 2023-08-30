package inflearn.chap8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No_5 {
    static int n;
    static int m;
    static int[] arr;
    static boolean[] check;
    static int answer;

    public void bfs(int L) {
        boolean endCheck = false;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.offer(arr[i]);
        }

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int num = queue.poll();

                if (num == m) {
                    endCheck = true;
                    answer = L;
                    break;
                }
                for (int j = n - 1; j >= 0; j--) {
                    if (num + arr[j] > m || check[num + arr[j]])
                        continue;

                    queue.offer(num + arr[j]);
                    check[num + arr[j]] = true;
                }
            }

            if (endCheck)
                break;

            L++;
        }
    }

    public static void main(String[] args) {
        No_5 T = new No_5();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        m = sc.nextInt();
        Arrays.sort(arr);
        check = new boolean[m + 1];
        T.bfs(1);

        System.out.println(answer);
    }
}
