package inflearn.chap9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class No_1 {

    static ArrayList<Applicant> arrayList = new ArrayList<>();

    static class Applicant implements Comparable<Applicant> {
        int height;
        int weight;

        public Applicant(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Applicant o) {
            if (this.height == weight)
                return this.weight - o.weight;

            return o.height - this.height;
        }
    }

    public int solution() {
        int answer = 0;
        int max = -1;
        Collections.sort(arrayList);

        for (Applicant applicant : arrayList) {
            if (applicant.weight >= max) {
                max = applicant.weight;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        No_1 T = new No_1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            arrayList.add(new Applicant(h, w));
        }
        System.out.println(T.solution());
    }
}
