package com.company.백준.DFSBFS.안전영역;


import java.util.Scanner;

public class Main {

    static int[][] area;
    static boolean[][] visited;
    static int[] dc = {-1, 0, 1, 0};
    static int[] dr = {0, -1, 0, 1};
    static int result = 1;
    static int N;

    public static void dfs(int r, int c, int h) {

        visited[r][c]=true;

        for (int i = 0; i < 4; i++) {
            int nr = r+ dr[i];
            int nc = c+dc[i];

            // exception
            if(nr<0||nc<0||nr>=N||nc>=N||
                    //물에 잠기거나 이미 확인한 곳이면 체크하지 않는다
                    area[nr][nc]<=h||visited[nr][nc]) continue;

            dfs(nr,nc,h);
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        N = in.nextInt();

        area = new int[N][N];
        visited = new boolean[N][N];

        int max = 0;

        for (int i = 0; i < area.length; i++) {

            for (int j = 0; j < area[i].length; j++) {
                int num = in.nextInt();

                area[i][j] = num;
                if (num <= 100) {
                    max = Math.max(num, max);
                }
            }
        }

        for (int h = 1; h <= max; h++) {
            init(); //visited배열 초기화

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(area[i][j]>h && !visited[i][j]) {//안전지대 발견
                        cnt++;
                        dfs(i,j,h);
                    }
                }
            }
            result = Math.max(cnt, result);
        }
        System.out.println(result);
    }

    private static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j]=false;
            }
        }
    }
}
















