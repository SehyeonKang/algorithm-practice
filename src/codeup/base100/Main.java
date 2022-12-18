package codeup.base100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.printf("%d", (a < b ? a : b) < c ? (a < b ? a : b) : c );
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
