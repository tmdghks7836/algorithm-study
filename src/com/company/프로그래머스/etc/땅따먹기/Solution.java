package com.company.프로그래머스.etc.땅따먹기;


import java.util.Arrays;

public class Solution {

    int[][] land;
    int[][] max;
    boolean[][] check;
    int[] curr;
    int answer;

    public void DFS(int num, int i) {

        if (i >= land.length) {
            answer = Math.max(num, answer);
            System.out.println(Arrays.toString(curr));
            return;
        }

        for (int k = 0; k < 4; k++) {

            if (!check[i - 1][k]) {

                check[i][k] = true;
                max[i][k] = num + land[i][k];
                DFS(num + land[i][k], i + 1);
                check[i][k] = false;
            }
        }
    }


    int solution(int[][] land) {

        check = new boolean[land.length][4];
        this.land = land;
        max = land;
        curr = new int[land.length];

        for (int i = 0; i < 4; i++) {

            check[0][i] = true;
            curr[0] = land[0][i];
            DFS(land[0][i], 1);
            check[0][i] = false;
        }


        return answer;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}});
        System.out.println(solution1);

    }
}