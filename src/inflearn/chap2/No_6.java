package inflearn.chap2;

import java.util.ArrayList;
import java.util.Scanner;

public class No_6 {
    public ArrayList<Integer> solution(int n, String[] arr) {
        StringBuffer sb;
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = new int[100000];
        tmp[1] = 1;
        for (int i = 2; i < 100000; i++) {
            if (tmp[i] == 0) {
                for (int j = i; j < 100000; j += i)
                    tmp[j] = 1;
                tmp[i] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            sb = new StringBuffer(arr[i]);
            int num = Integer.valueOf(sb.reverse().toString());
            if (tmp[num] == 0)
                answer.add(num);
        }

        return answer;
    }

    public static void main(String[] args) {
        No_6 T = new No_6();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        ArrayList<Integer> answer = T.solution(n, arr);

        for (int x : answer) {
            System.out.print(x + " ");
        }
    }
}
