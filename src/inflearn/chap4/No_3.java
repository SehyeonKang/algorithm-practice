package inflearn.chap4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class No_3 {
    public ArrayList<Integer> solution(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int lt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        answer.add(map.size());

        for (int rt = k; rt < n; rt++) {
            if (map.get(arr[lt]) == 1) {
                map.remove(arr[lt]);
            } else {
                map.put(arr[lt], map.get(arr[lt]) - 1);
            }
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            lt++;
            answer.add(map.size());
        }

        return answer;
    }

    public static void main(String[] args) {
        No_3 T = new No_3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> answer = T.solution(n, k , arr);

        for (int x : answer) {
            System.out.print(x + " ");
        }
    }
}
