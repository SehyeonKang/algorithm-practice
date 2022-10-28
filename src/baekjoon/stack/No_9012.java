package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());


        for(int i = 0; i < T; i++) {
            String s = solve(br.readLine());
            sb.append(s).append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    public static String solve(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            //여는 괄호일 경우 스택에 넣기
            if(c == '(') {
                stack.push(c);
            }
            //닫는 괄호이고 스택이 비어있을 경우
            else if(stack.empty()) {
                return "NO";
            } else {
                stack.pop();
            }
        }

        //다 끝난 후 여는 괄호가 없을 경우와 많을 경우
        if(stack.empty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
