package baekjoon.short_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 벨만-포드 알고리즘
 */
public class No_11657 {

    static int N, M;
    static ArrayList<ArrayList<City>> array;
    static long[] dist;
    static final int INF = 6000000;

    private static class City {
        int end, weight;

        public City(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new ArrayList<>();
        dist = new long[N + 1];

        for (int i = 0; i <= N; i++) {
            array.add(new ArrayList<>());
            dist[i] = INF;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            array.get(A).add(new City(B, C));
        }

        if (bellmanFord()) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    sb.append(-1).append("\n");
                } else
                    sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
    }

    private static boolean bellmanFord() {

        dist[1] = 0;
        boolean update = false;

        /**
         * 모든 정점에 대해 최단 경로 갱신을 최대 N-1번 반복
         * 중간에 갱신되지않을 경우 갱신이 끝난것으로 보고 break
         */
        for (int i = 1; i < N; i++) {
            update = false;

            for (int j = 1; j <= N; j++) {
                for (City city : array.get(j)) {
                    if (dist[j] == INF)
                        break;

                    if (dist[city.end] > dist[j] + city.weight) {
                        dist[city.end] = dist[j] + city.weight;
                        update = true;
                    }
                }
            }

            if (!update)
                break;
        }

        /**
         * N-1번 사이클을 돌려서 끝까지 최단 경로가 갱신될 경우
         * N번째 사이클에서 갱신되면 음의 사이클이 존재
         */
        if (update) {
            for (int i = 1; i <= N; i++) {
                for (City city : array.get(i)) {
                    if (dist[i] == INF)
                        break;

                    if (dist[city.end] > dist[i] + city.weight) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
