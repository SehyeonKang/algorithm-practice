package inflearn.chap8;

import java.util.ArrayList;
import java.util.Scanner;

public class No_3 {
    static int n;
    static int m;
    static int totalTime = 0;
    static int totalScore = 0;
    static int answer = 0;
    static ArrayList<Quest> array = new ArrayList<>();

    static class Quest {
        int score;
        int time;

        public Quest(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }

    public void dfs(int L) {
        if (totalTime > m)
            return;

        if (L == n) {
            answer = Math.max(answer, totalScore);
            return;
        }

        totalScore += array.get(L).score;
        totalTime += array.get(L).time;
        dfs(L + 1);

        totalScore -= array.get(L).score;
        totalTime -= array.get(L).time;
        dfs(L + 1);
    }

    public static void main(String[] args) {
        No_3 T = new No_3();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();
            int time = sc.nextInt();
            array.add(new Quest(score, time));
        }

        T.dfs(0);

        System.out.println(answer);
    }
}
