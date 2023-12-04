package com.company.etc.프로그래머스.etc.카카오프렌즈컬러링북;



public class Solution {

    private boolean[][] check;
    private int[] xDir = {-1, 0, 1, 0};
    private int[] yDir = {0, -1, 0, 1};
    int[][] picture;
    int count;
    int m, n;

    public void DFS(int i, int j, int style) {

        check[i][j] = true;
        count++;
        for (int k = 0; k < 4; k++) {

            int yd = yDir[k] + i;
            int xd = xDir[k] + j;

            if (yd >= 0 && xd >= 0 && yd < m && xd < n)
                if (!check[yd][xd] && picture[yd][xd] == style) {
                    DFS(yd, xd, style);
                }
        }
    }

    public int[] solution(int m, int n, int[][] picture) {


        this.m = m;
        this.n = n;
        int[] answer = new int[2];

        check = new boolean[m][n];
        this.picture = picture;
        for (int i = 0; i < picture.length; i++) {
            for (int i1 = 0; i1 < picture[i].length; i1++) {

                if (!check[i][i1] && picture[i][i1] != 0) {
                    count = 0;
                    answer[0] += 1;
                    DFS(i, i1, picture[i][i1]);

                    answer[1] = Math.max(count, answer[1]);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});

        for (int i : solution1) {
            System.out.println(i);
        }
    }
}