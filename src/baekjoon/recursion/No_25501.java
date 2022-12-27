package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_25501 {

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cases = Integer.parseInt(br.readLine());

        for (int i = 0; i < cases; i++) {
            String s = br.readLine();
            char[] arr = s.toCharArray();
            sb.append(isPalindrome(arr)).append(" ").append(cnt).append("\n");
            cnt = 0;
        }

        System.out.println(sb);
    }

    public static int isPalindrome(char[] arr) {
        return recursion(arr, 0, arr.length - 1);
    }

    public static int recursion(char[] arr, int l, int r) {

        cnt++;

        if (l >= r) {
            return 1;
        } else if (arr[l] != arr[r]) {
            return 0;
        } else {
            return recursion(arr, l + 1, r - 1);
        }
    }
}
