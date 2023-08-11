package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String s = br.readLine();
            if(s.equals("."))
                break;

            String result = solve(s);
            sb.append(result).append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    public static String solve(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if(stack.empty())
                    return "no";

                char pop = stack.pop();

                if(pop != '(')
                    return "no";
            } else if (c == ']') {
                if(stack.empty())
                    return "no";

                char pop = stack.pop();

                if(pop != '[')
                    return "no";
            } else
                continue;
        }

        //다 끝난 후 여는 괄호가 없을 경우와 많을 경우
        if(stack.empty()) {
            return "yes";
        } else {
            return "no";
        }
    }
}
