package programmers.check_test;

public class No_4 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        int[] ans = solution(100, 97, arr);

    }

    static private int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        int[][] map = new int[rows][columns];
        int num = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = num++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];

            
        }

        return answer;
    }
}
