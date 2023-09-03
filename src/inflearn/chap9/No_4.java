package inflearn.chap9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class No_4 {

    static int n;
    static int maxTime = 0;
    static ArrayList<Lecture> arr = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    static class Lecture implements Comparable<Lecture> {
        int money;
        int time;

        public Lecture(int money, int time) {
            this.money = money;
            this.time = time;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.time - this.time;
        }
    }

    public int solution() {
        int answer = 0;
        int j = 0;
        Collections.sort(arr);

        for (int i = maxTime; i >= 1; i--) {
            for (; j < n; j++) {
                if (arr.get(j).time < i)
                    break;

                pq.offer(arr.get(j).money);
            }
            if (!pq.isEmpty())
                answer += pq.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        No_4 T = new No_4();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int money = sc.nextInt();
            int time = sc.nextInt();
            arr.add(new Lecture(money, time));
            maxTime = Math.max(maxTime, time);
        }
        System.out.println(T.solution());
    }
}
