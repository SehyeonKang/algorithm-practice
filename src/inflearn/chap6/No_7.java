package inflearn.chap6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class No_7 {
    static class Point implements Comparable<Point>{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) {
                return this.y - o.y;
            } else
                return this.x - o.x;
        }
    }
    public ArrayList<Point> solution(ArrayList<Point> arr) {
        Collections.sort(arr);
        return arr;
    }

    public static void main(String[] args) {
        No_7 T = new No_7();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Point(x, y));
        }
        ArrayList<Point> answer = T.solution(arr);

        for (Point point : answer) {
            System.out.println(point.x + " " + point.y);
        }
    }
}
