package inflearn.chap10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class No_4 {

    static int n;
    static int[] dp;
    static ArrayList<Block> array = new ArrayList<>();

    static class Block implements Comparable<Block> {
        int area;
        int height;
        int weight;

        public Block(int area, int height, int weight) {
            this.area = area;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Block o) {
            return this.area - o.area;
        }
    }

    public int solution() {
        int answer = 0;
        Collections.sort(array);
        dp[0] = array.get(0).height;

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (array.get(j).area < array.get(i).area && array.get(j).weight < array.get(i).weight && max < dp[j])
                    max = dp[j];
            }
            dp[i] = max + array.get(i).height;
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        No_4 T = new No_4();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int h = sc.nextInt();
            int w = sc.nextInt();

            array.add(new Block(a, h, w));
        }
        System.out.println(T.solution());
    }
}
