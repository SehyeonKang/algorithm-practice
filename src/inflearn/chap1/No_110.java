package inflearn.chap1;

import java.util.Scanner;

public class No_110 {
    public int[] solution(String s, char t) {
        int[] answer = new int[s.length()];
        int dis = 1000;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t) {
                dis++;
                answer[i] = dis;
            } else {
                dis = 0;
            }
        }

        dis = 1000;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != t) {
                dis++;
                answer[i] = Math.min(dis, answer[i]);
            } else {
                dis = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        No_110 T = new No_110();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char t = sc.next().charAt(0);
        int[] answer = T.solution(s, t);

        for (int i = 0; i < s.length(); i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
