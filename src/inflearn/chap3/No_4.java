package inflearn.chap3;

import java.util.Scanner;

public class No_4 {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int p1 = 0;
        int p2 = 1;
        int sum = arr[0];

        while (p2 < n) {
            if (sum == m) {
                answer++;
                sum += arr[p2++];
            } else if (sum < m) {
                sum += arr[p2++];
            } else {
                if (p1 == p2) {
                    sum = arr[p2++];
                    p1++;
                } else {
                    sum -= arr[p1++];
                }
            }
        }

        if (sum == m)
            answer++;

        return answer;
    }

    public int solution2(int n, int m, int[] arr){
        int answer=0, sum=0, lt=0;
        for(int rt=0; rt<n; rt++){
            sum+=arr[rt];
            if(sum==m) answer++;
            while(sum>=m){
                sum-=arr[lt++];
                if(sum==m) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        No_4 T = new No_4();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, m, arr));
    }
}
