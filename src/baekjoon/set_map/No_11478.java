package baekjoon.set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class No_11478{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Set<String> set = new HashSet<String>();
        String str = br.readLine();
        String subStr;

        for(int i=0; i<str.length(); i++) {
            subStr = "";

            for(int j=i; j<str.length(); j++) {
                subStr += str.substring(j, j + 1);
                set.add(subStr);
            }
        }

        sb.append(set.size());
        System.out.println(sb);

        br.close();
    }
}
