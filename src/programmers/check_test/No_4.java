package programmers.check_test;

public class No_4 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
        int[] ans = solution(3, 3, arr);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + ", ");
        }
    }

    static private int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];
        int num = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = num++;
            }
        }

        for (int j = 0; j < rows; j++) {
            for (int k = 0; k < columns; k++) {
                System.out.print(map[j][k] + ", ");
            }
            System.out.println();
        }

        System.out.println("==============");

        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];

            int min = 10001;
            int tmp1 = map[x1 - 1][y1 - 1];
            int tmp2;

            for (int j = x1; j <= x2 - 1; j++) {
                if (tmp1 < min)
                    min = tmp1;

                tmp2 = map[y1 - 1][j];
                map[y1 - 1][j] = tmp1;
                tmp1 = tmp2;
            }

            for (int j = y1; j <= y2 - 1; j++) {
                if (tmp1 < min)
                    min = tmp1;

                tmp2 = map[j][x2 - 1];
                map[j][x2 - 1] = tmp1;
                tmp1 = tmp2;
            }

            for (int j = x2 - 2; j >= x1 - 1; j--) {
                if (tmp1 < min)
                    min = tmp1;

                tmp2 = map[y2 - 1][j];
                map[y2 - 1][j] = tmp1;
                tmp1 = tmp2;
            }

            for (int j = y2 - 2; j >= y1 - 1; j--) {
                if (tmp1 < min)
                    min = tmp1;

                tmp2 = map[j][x1 - 1];
                map[j][x1 - 1] = tmp1;
                tmp1 = tmp2;
            }

            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    System.out.print(map[j][k] + ", ");
                }
                System.out.println();
            }

            System.out.println("==============");

            answer[i] = min;
        }

        return answer;
    }
}
