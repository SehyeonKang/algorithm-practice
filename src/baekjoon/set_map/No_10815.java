package baekjoon.set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No_10815 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int m, num;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++) {
            num = Integer.parseInt(st.nextToken());
            if(binarySearch(arr, num)) {
                sb.append("1 ");
            } else
                sb.append("0 ");
        }

        System.out.println(sb);

        br.close();
    }

    public static boolean binarySearch(int[] arr, int num) {
        int leftIndex = 0;
        int rightIndex = arr.length - 1;

        while(leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            int midNum = arr[midIndex];

            if(midNum > num) {
                rightIndex = midIndex - 1;
            } else if(midNum < num){
                leftIndex = midIndex + 1;
            } else
                return true;
        }

        return false;
    }
}
