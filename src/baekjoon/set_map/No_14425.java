package baekjoon.set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No_14425 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        int cnt = 0;

        for(int i = 0; i < n; i++)
            map.put(br.readLine(), 1);

        for(int i = 0; i < m; i++) {
            String s = br.readLine();
            if(map.get(s) != null)
                cnt++;
        }

        sb.append(cnt);

        System.out.println(sb);

        br.close();
    }
}
