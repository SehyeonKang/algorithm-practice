package inflearn.chap8;

import java.util.Arrays;
import java.util.Scanner;

public class No_1 {
    static int n;
    static int[] arr;
    static int sum = 0;
    static int arrSum;
    static String answer = "NO";

    public void dfs(int num) {
        if (answer == "YES" || sum > arrSum / 2)
            return;

        if (num == arr.length) {
            if (sum == arrSum - sum) {
                answer = "YES";
            }
            return;
        }

        sum += arr[num];
        dfs(num + 1);
        sum -= arr[num];
        dfs(num + 1);
    }

    public void solution() {
        arrSum = Arrays.stream(arr).sum();
        sum += arr[0];
        dfs(1);
    }

    public static void main(String[] args) {
        No_1 T = new No_1();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        T.solution();

        System.out.println(answer);
    }
}
