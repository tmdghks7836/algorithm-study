package com.company.백준.DFSBFS.케빈베이컨의6단계;

import java.util.*;

public class Main {

    int result = Integer.MAX_VALUE;

    /**
     *
     */
    public void solution() {

        Scanner sc = new Scanner(System.in);

        /**
         *
         *
         * 지구에 있는 모든 사람들은 최대 6단계 이내에서 서로 아는 사람으로 연결될수잇다.
         * 임의의 두 사람이 최소 몇단계만에 이어질 수 있는지
         * */


        int N = sc.nextInt();

        int M = sc.nextInt();

        long[][] grid = new long[N][N];
        for (int i = 0; i < M; i++) {

            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            grid[from][to] = 1;
            grid[to][from] = 1;
        }

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {

                if(grid[i][j] == 1) continue;
                if(i == j) continue;

                grid[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int k = 0; k < N; k++) {

            for (int i = 0; i < N; i++) {

                for (int j = 0; j < N; j++) {

                    floyte(grid, i, j, k);
                }

            }

        }

        int answer = 0;

        for (int i = 0; i < grid.length; i++) {


            int sum = Arrays.stream(grid[i]).mapToInt(value -> (int) value).sum();

            if(sum < result){
                answer = i + 1;
            }
            result = Math.min(sum, result);
        }
        System.out.println(answer);
    }

    private void floyte(long[][] grid, int i, int j, int k) {

        if(i == j) return;

        grid[i][j] = Math.min(grid[i][j], grid[i][k] + grid[k][j]);
    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}