package baekjoon.set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class No_1269 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            setA.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++)
            setB.add(Integer.parseInt(st.nextToken()));

        int result = 0;

        for(int num : setA) {
            if(!setB.contains(num))
                result++;
        }

        for(int num : setB) {
            if(!setA.contains(num))
                result++;
        }

        sb.append(result);

        System.out.println(sb);

        br.close();
    }
}
