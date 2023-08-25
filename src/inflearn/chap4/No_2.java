package inflearn.chap4;

import java.util.HashMap;
import java.util.Scanner;

public class No_2 {
    public String solution(String s1, String s2) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : s1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (char x : s2.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0)
                return "NO";

            map.put(x, map.get(x) - 1);
        }

        for (char x : s1.toCharArray()) {
            if (map.get(x) > 0)
                return "NO";
        }

        return answer;
    }

    public static void main(String[] args) {
        No_2 T = new No_2();
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(T.solution(s1, s2));
    }
}
