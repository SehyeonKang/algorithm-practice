package baekjoon.set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No_1764 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++)
            map.put(br.readLine(), 0);

        ArrayList<String> arr = new ArrayList<String>();
        int count = 0;

        for(int i=0; i<m; i++) {
            String s = br.readLine();
            if(map.containsKey(s)) {
                arr.add(s);
                count++;
            }
        }

        Collections.sort(arr);
        sb.append(count + "\n");

        for(int i=0; i<arr.size(); i++)
            sb.append(arr.get(i) + "\n");

        System.out.println(sb);

        br.close();
    }
}
