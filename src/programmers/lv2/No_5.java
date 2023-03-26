package programmers.lv2;

/**
 * 숫자의 표현
 */
public class No_5 {

    public static void main(String[] args) {
        int result = solution(15);
        System.out.println(result);
    }

    private static int solution(int n) {
        int answer = 1;

        for (int i = 1; i <= n / 2; i++) {
            int sum = 0;
            int num = i;

            while (true) {
                sum += num++;

                if (sum == n) {
                    answer++;
                    break;
                } else if (sum > n)
                    break;
            }
        }

        return answer;
    }
}
