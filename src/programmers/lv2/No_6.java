package programmers.lv2;

public class No_6 {

    public static void main(String[] args) {
        int ans = solution(15);
        System.out.println(ans);
    }

    private static int solution(int n) {
        int answer = 0;
        int count = calculate(n);

        while (true) {
            n++;
            if (calculate(n) == count) {
                answer = n;
                break;
            }
        }

        return answer;
    }

    private static int calculate(int n) {
        int result = 0;

        while (true) {
            if (n % 2 == 1)
                result++;

            n /= 2;

            if (n == 0)
                break;
        }

        return result;
    }
}
