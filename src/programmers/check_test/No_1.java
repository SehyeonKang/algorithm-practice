package programmers.check_test;

public class No_1 {

    public static void main(String[] args) {
        int result = solution("3333");

        System.out.println(result);
    }

    static private int solution(String s) {
        int answer = 0;
        int arrLen = 0;

        char[] arr = s.toCharArray();
        arrLen = arr.length;

        if (arr[0] == '+') {
            arrLen--;
            for (int i = 0; i < arrLen; i++) {
                answer += Character.getNumericValue(arr[arrLen - i]) * Math.pow(10, i);
            }
        } else if (arr[0] == '-') {
            arrLen--;
            for (int i = 0; i < arrLen; i++) {
                answer += Character.getNumericValue(arr[arrLen - i]) * Math.pow(10, i);
            }
            answer *= -1;
        } else {
            for (int i = 0; i < arrLen; i++) {
                answer += Character.getNumericValue(arr[arrLen - i - 1]) * Math.pow(10, i);
            }
        }

        return answer;
    }
}
