package codeup.base100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 100번째 문제
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[11][11];
        int row = 2;
        int col = 2;
        int chk = 0;

        for (int i = 1; i <= 10; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= 10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while (true) {
            if (arr[row][col] == 2) {
                arr[row][col] = 9;
                break;
            }

            if (chk == 0) {
                arr[row][col] = 9;
                chk++;
            }

            if (arr[row][col + 1] == 0) {
                col++;
            } else if (arr[row][col + 1] == 2) {
                col++;
                arr[row][col] = 9;
                break;
            } else {
                if (arr[row + 1][col] == 0) {
                    row++;
                } else if (arr[row + 1][col] == 2) {
                    row++;
                    arr[row][col] = 9;
                    break;
                } else {
                    break;
                }
            }

            arr[row][col] = 9;
        }

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}

/*
public void results() {
    System.out.print("Hello");
    System.out.print("Hello World");
    System.out.print("Hello\nWorld");
    System.out.print("\'Hello\'");
    System.out.print("\"Hello World\"");
    System.out.print("\"!@#$%^&*()\"");
    System.out.print("\"C:\\Download\\hello.cpp\"");
    System.out.println("\u250C\u252C\u2510");
}
*/
