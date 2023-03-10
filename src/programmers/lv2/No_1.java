package programmers.lv2;

import java.util.Arrays;

/**
 * 최댓값과 최솟값
 */
public class No_1 {

    public static void main(String[] args) {
        String ans = solution("1 2 3 4");
        System.out.println(ans);
    }

    static private String solution(String s) {
        String answer = "";

        String[] sArr = s.split(" ");
        int[] arr = new int[sArr.length];

        for (int i = 0; i < sArr.length; i++) {
            arr[i] = Integer.parseInt(sArr[i]);
        }
        Arrays.sort(arr);

        answer =  arr[0] + " " + arr[arr.length - 1];

        return answer;
    }
}
