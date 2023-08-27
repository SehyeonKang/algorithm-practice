package inflearn.chap6;

import java.util.Scanner;

public class No_1 {
    public int[] solution(int n, int[] arr) {
        int min = Integer.MAX_VALUE;
        int check = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    check = j;
                }
            }

            if (arr[i] > min) {
                int tmp = arr[i];
                arr[i] = arr[check];
                arr[check] = tmp;
            }

            min = Integer.MAX_VALUE;
        }

        return arr;
    }

    public int[] solution2(int n, int[] arr){
        for(int i=0; i<n-1; i++){
            int idx=i;
            for(int j=i+1; j<n; j++){
                if(arr[j]<arr[idx]) idx=j;
            }
            int tmp=arr[i];
            arr[i]=arr[idx];
            arr[idx]=tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        No_1 T = new No_1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] answer = T.solution(n, arr);

        for (int x : answer) {
            System.out.print(x + " ");
        }
    }
}
