package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No_2110 {

    static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        house = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int lo = 0;
        int hi = house[N - 1];

        while (lo < hi) {

            int mid = (lo + hi) / 2;

            if (install(mid) < C) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(lo - 1);
    }

    private static int install(int distance) {

        int count = 1;
        int lastPos = house[0];

        for (int i = 1; i < house.length; i++) {
            if (distance <= house[i] - lastPos) {
                count++;
                lastPos = house[i];
            }
        }

        return count;
    }
}
