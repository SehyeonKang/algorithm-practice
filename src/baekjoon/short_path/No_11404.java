package baekjoon.short_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 플로이드 알고리즘
 */
public class No_11404 {

    static int cityNum, busNum;
    static int[][] distance;
    static final int INF = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        cityNum = Integer.parseInt(br.readLine());
        busNum = Integer.parseInt(br.readLine());

        distance = new int[cityNum + 1][cityNum + 1];

        for (int i = 1; i <= cityNum; i++) {
            for (int j = 1; j <= cityNum; j++) {
                if (i == j)
                    continue;
                distance[i][j] = INF;
            }
        }

        for (int i = 0; i < busNum; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            distance[start][end] = Math.min(distance[start][end], dist);
        }

        floyd();

        for (int i = 1; i <= cityNum; i++) {
            for (int j = 1; j <= cityNum; j++) {
                if (distance[i][j] >= INF) {
                    sb.append("0 ");
                } else
                    sb.append(distance[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static void floyd() {

        /**
         * 출발 노드: j
         * 도착 노드: k
         * 거쳐가는 노드: i
         */
        for (int i = 1; i <= cityNum; i++) {
            for (int j = 1; j <= cityNum; j++) {
                for (int k = 1; k <= cityNum; k++) {
                    distance[j][k] = Math.min(distance[j][i] + distance[i][k], distance[j][k]);
                }
            }
        }
    }
}
