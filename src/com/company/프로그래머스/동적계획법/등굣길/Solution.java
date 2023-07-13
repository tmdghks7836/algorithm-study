
package com.company.프로그래머스.동적계획법.등굣길;


class Solution {

    public int solution(int m, int n, int[][] puddles) {

        int[][] arr = new int[n + 1][m + 1];

        arr[1][1] = 1;

        for (int i = 0; i < puddles.length; i++) {

            arr[puddles[i][1]][puddles[i][0]] = -1;
        }

        for (int i = 1; i < arr.length; i++) {

            for (int j = 1; j < arr[i].length; j++) {

                if (arr[i][j] == -1) continue;
                if (i == 1 && j == 1) continue;

                int up = arr[i - 1][j] == -1 ? 0 : arr[i - 1][j];
                int left = arr[i][j - 1] == -1 ? 0 : arr[i][j - 1];
                arr[i][j] = (up % 1000000007) + (left % 1000000007);
            }
        }

        return arr[n][m] % 1000000007;
    }

    public static void main(String[] args) {

        Solution T = new Solution();

        System.out.println(T.solution(4, 3, new int[][]{{2, 2}}));
    }

}
