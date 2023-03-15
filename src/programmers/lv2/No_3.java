package programmers.lv2;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 최솟값 만들기
 */
public class No_3 {

    public static void main(String[] args) {
        int ans = solution(new int[]{1, 4, 2}, new int[]{5, 4, 4});
        System.out.println(ans);
    }

    private static int solution(int []A, int []B)
    {
        int answer = 0;

        PriorityQueue<Integer> a = new PriorityQueue<>();
        PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            a.add(A[i]);
            b.add(B[i]);
        }

        for (int i = 0; i < A.length; i++) {
            answer += a.poll() * b.poll();
        }

        return answer;
    }
}
