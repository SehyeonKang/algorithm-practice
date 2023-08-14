package inflearn.chap1;

import java.util.Scanner;

public class No_16 {
    public String solution(String str) {
        String answer = "";
        int[] arr = new int[26];

        for (char c : str.toCharArray()) {
            if (arr[c - 97] == 0) {
                arr[c - 97] = 1;
                answer += c;
            }
        }

        return answer;
    }

    public String solution2(String str){
        String answer="";
        for(int i = 0; i < str.length(); i++){
            if(str.indexOf(str.charAt(i)) == i)
                answer += str.charAt(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        No_16 T = new No_16();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
