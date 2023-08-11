package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_11 {
    public int solution(String str, char t) {
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);

        /*for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == t)
                answer++;
        }*/

        for (char c : str.toCharArray()) {
            if (c == t)
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        No_11 T = new No_11();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input1 = br.readLine();
        char input2 = br.readLine().charAt(0);

        System.out.println(T.solution(input1, input2));
    }
}
