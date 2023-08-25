package inflearn.chap4;

import java.util.HashMap;
import java.util.Scanner;

public class No_4 {
    public int solution(String s, String t) {
        int answer = 0;
        int lt = 0;
        char[] arr = s.toCharArray();
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < t.length() - 1; i++) {
            mapS.put(arr[i], mapS.getOrDefault(arr[i], 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (int rt = t.length() - 1; rt < s.length(); rt++) {
            mapS.put(arr[rt], mapS.getOrDefault(arr[rt], 0) + 1);
            if (mapS.equals(mapT))
                answer++;

            mapS.put(arr[lt], mapS.get(arr[lt]) - 1);
            if (mapS.get(arr[lt]) == 0)
                mapS.remove(arr[lt]);
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        No_4 T = new No_4();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println(T.solution(s, t));
    }
}
