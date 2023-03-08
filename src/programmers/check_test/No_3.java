package programmers.check_test;

public class No_3 {

    public static void main(String[] args) {
        int ans[] = solution(24, 24);

        System.out.println("[" + ans[0] + ", " + ans[1] + "]");
    }

    static private int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                int x = yellow / i;
                int y = i;

                if (brown == 2 * x + 2 * y + 4) {
                    answer[0] = x + 2;
                    answer[1] = y + 2;
                    break;
                }
            }
        }

        return answer;
    }
}
