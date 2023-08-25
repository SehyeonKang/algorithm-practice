package inflearn.chap3;

import java.util.Scanner;

public class No_6 {
    public int solution(int n, int k, int[] arr) {
        int answer = 0;
        int lt = 0;
        int count = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 1) {
                sum++;
                max = Math.max(max, sum);
            } else {
                if (count == k) {
                    sum++;
                    while (true) {
                        if (arr[lt] == 0) {
                            sum--;
                            lt++;
                            break;
                        }
                        sum--;
                        lt++;
                    }
                } else {
                    count++;
                    sum++;
                }
            }
        }
        answer = max;
        return answer;
    }

    public int solution2(int n, int k, int[] arr){
        int answer=0, cnt=0, lt=0;
        for(int rt=0; rt<n; rt++){
            if(arr[rt]==0) cnt++;
            while(cnt>k){
                if(arr[lt]==0) cnt--;
                lt++;
            }
            answer=Math.max(answer, rt-lt+1);
        }
        return answer;
    }

    public static void main(String[] args) {
        No_6 T = new No_6();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, k, arr));
    }
}
