
package com.company.etc.프로그래머스.완전탐색.피로도;


class Solution {

    boolean[] check;
    int result = 0;


    public void DFS(int tired, int[][] dungeons, int cnt) {

        result = Math.max(cnt, result);

        for (int i = 0; i < dungeons.length; i++) {

            if (!check[i] && dungeons[i][0] <= tired) {
                check[i] = true;
                DFS(tired - dungeons[i][1], dungeons, cnt + 1);
                check[i] = false;
            }
        }
    }

    public int solution(int k, int[][] dungeons) {

        check = new boolean[dungeons.length];
        DFS(k, dungeons, 0);

        return result;
    }

    public static void main(String[] args) {

        Solution T = new Solution();

        System.out.println(T.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }

}
