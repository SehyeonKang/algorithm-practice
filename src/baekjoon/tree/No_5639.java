package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_5639 {

    static Node root;
    static StringBuilder sb = new StringBuilder();

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        root = new Node(num, null, null);

        while (true) {
            String input = br.readLine();

            if (input == null || input.equals(""))
                break;

            insertNode(root, Integer.parseInt(input));
        }

        postOrder(root);
        System.out.println(sb);

        br.readLine();
    }

    private static void insertNode(Node tmp, int num) {
        if (num < tmp.value) {
            if (tmp.left == null) {
                tmp.left = new Node(num, null, null);
            } else
                insertNode(tmp.left, num);
        } else {
            if (tmp.right == null) {
                tmp.right = new Node(num, null, null);
            } else
                insertNode(tmp.right, num);
        }
    }

    private static void postOrder(Node parent) {
        if (parent == null)
            return;

        postOrder(parent.left);
        postOrder(parent.right);
        sb.append(parent.value).append("\n");
    }
}
