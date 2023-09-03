package inflearn.chap9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class No_2 {

    static ArrayList<Meeting> array = new ArrayList<>();

    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end)
                return this.start - o.start;

            return this.end - o.end;
        }
    }

    public int solution() {
        int answer = 0;
        int endTime = 0;
        Collections.sort(array);

        for (Meeting m : array) {
            if (m.start >= endTime) {
                endTime = m.end;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        No_2 T = new No_2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            array.add(new Meeting(s, e));
        }
        System.out.println(T.solution());
    }
}
