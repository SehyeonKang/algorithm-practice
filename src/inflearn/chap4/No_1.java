package inflearn.chap4;

import java.util.HashMap;
import java.util.Scanner;

public class No_1 {
    public char solution(int n, String s) {
        char answer = 0;
        int max = 0;
        char[] arr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (char x : map.keySet()) {
            if (max < map.get(x)) {
                max = map.get(x);
                answer = x;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        No_1 T = new No_1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        System.out.println(T.solution(n ,s));
    }
}
