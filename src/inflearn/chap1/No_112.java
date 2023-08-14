package inflearn.chap1;

import java.util.Scanner;

public class No_112 {
    public String solution(int n, String str) {
        String answer = "";

        for (int i = 0; i < n; i++) {
            String s = str.substring(i * 7, i * 7 + 7);
            int num = 0;

            for (int j = 0; j < 7; j++) {
                if (s.charAt(j) == '#')
                    num += Math.pow(2, 6 - j);
            }
            char c = (char) num;
            answer += c;
        }

        return answer;
    }

    public String solution2(int n, String s){
        String answer="";
        for(int i=0; i<n; i++){
            String tmp=s.substring(0, 7).replace('#', '1').replace('*', '0');
            int num=Integer.parseInt(tmp, 2);
            answer+=(char)num;
            s=s.substring(7);
        }
        return answer;
    }

    public static void main(String[] args) {
        No_112 T = new No_112();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(T.solution(n, str));
    }
}
