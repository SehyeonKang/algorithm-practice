package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1991 {

    static Node root = new Node('A', null, null);
    static StringBuilder sb = new StringBuilder();
    private static class Node {

        char value;
        Node left;
        Node right;

        Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(root, parent, left, right);
        }

        preOrder(root);
        sb.append("\n");
        inOrder(root);
        sb.append("\n");
        postOrder(root);

        System.out.println(sb);

    }

    private static void insertNode(Node tmp, char parent, char left, char right) {
        if (tmp.value == parent) {
            tmp.left = left == '.' ? null : new Node(left, null, null);
            tmp.right = right == '.' ? null : new Node(right, null, null);
        } else {
            if (tmp.left != null)
                insertNode(tmp.left, parent, left, right);

            if (tmp.right != null)
                insertNode(tmp.right, parent, left, right);
        }
    }

    private static void preOrder(Node parent) {
        if (parent == null)
            return;

        sb.append(parent.value);
        preOrder(parent.left);
        preOrder(parent.right);
    }

    private static void inOrder(Node parent) {
        if (parent == null)
            return;

        inOrder(parent.left);
        sb.append(parent.value);
        inOrder(parent.right);
    }

    private static void postOrder(Node parent) {
        if (parent == null)
            return;

        postOrder(parent.left);
        postOrder(parent.right);
        sb.append(parent.value);
    }
}
