package inflearn.chap10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class No_6 {

    static int n, m;
    static int[] dp;
    static ArrayList<Quest> arrayList = new ArrayList<>();

    static class Quest implements Comparable<Quest> {
        int score;
        int time;

        public Quest(int score, int time) {
            this.score = score;
            this.time = time;
        }

        @Override
        public int compareTo(Quest o) {
            return this.time - o.time;
        }
    }

    public int solution() {
        Collections.sort(arrayList);

        for (Quest q : arrayList) {
            int score = q.score;
            int time = q.time;

            for (int i = m; i >= q.time; i--) {
                dp[i] = Math.max(dp[i], dp[i - time] + score);
            }
        }

        return dp[m];
    }

    public static void main(String[] args) {
        No_6 T = new No_6();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        dp = new int[m + 1];
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            arrayList.add(new Quest(s, t));
        }
        System.out.println(T.solution());
    }
}
