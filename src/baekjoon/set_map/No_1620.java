package baekjoon.set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No_1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        String[] name = new String[n + 1];
        int num = 1;

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            map.put(s, num++);
            name[i + 1] = s;
        }

        for(int i = 0; i < m; i++) {
            String s = br.readLine();
            if(isNumeric(s)) {
                sb.append(name[Integer.parseInt(s)] + "\n");
            } else
                sb.append(map.get(s) + "\n");
        }

        System.out.println(sb);

        br.close();
    }

    public static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}
