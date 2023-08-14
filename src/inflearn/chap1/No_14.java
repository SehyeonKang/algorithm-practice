package inflearn.chap1;

import java.util.ArrayList;
import java.util.Scanner;

public class No_14 {
    public ArrayList<String> solution(String[] arr) {
        ArrayList<String> answer = new ArrayList<>();
        String tmp = "";

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i].length() - 1; j >= 0; j--) {
                tmp += arr[i].charAt(j);
            }
            answer.add(tmp);
            tmp = "";
        }

        return answer;
    }

    public ArrayList<String> solution2(String[] str){
        ArrayList<String> answer=new ArrayList<>();
        for(String x : str){
            String tmp=new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }
        return answer;
    }

    public ArrayList<String> solution3(String[] str){
        ArrayList<String> answer=new ArrayList<>();
        for(String x : str){
            char[] s = x.toCharArray();
            int lt = 0;
            int rt = x.length() - 1;

            while (lt < rt) {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }

            String tmp = String.valueOf(s);
            answer.add(tmp);
        }
        return answer;
    }

    public static void main(String[] args) {
        No_14 T = new No_14();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        for (String x : T.solution(arr)) {
            System.out.println(x);
        }
    }
}
