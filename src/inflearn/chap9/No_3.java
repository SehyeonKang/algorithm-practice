package inflearn.chap9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class No_3 {

    static ArrayList<Time> array = new ArrayList<>();

    static class Time implements Comparable<Time> {
        int time;
        char state;

        public Time(int time, char state) {
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Time o) {
            if (this.time == o.time)
                return this.state - o.state;

            return this.time - o.time;
        }
    }

    public int solution() {
        int answer = Integer.MIN_VALUE;
        int count = 0;
        Collections.sort(array);

        for (Time t : array) {
            if (t.state == 's') {
                count++;
                answer = Math.max(answer, count);
            } else
                count--;
        }

        return answer;
    }

    public static void main(String[] args) {
        No_3 T = new No_3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            array.add(new Time(s, 's'));
            array.add(new Time(e, 'e'));
        }
        System.out.println(T.solution());
    }
}
