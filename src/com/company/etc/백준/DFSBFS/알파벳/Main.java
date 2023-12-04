package com.company.etc.백준.DFSBFS.알파벳;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 세로 R칸, 가로 C칸으로 된 표 모양의 보드가 있다. 보드의 각 칸에는 대문자 알파벳이 하나씩 적혀 있고, 좌측 상단 칸 (1행 1열) 에는 말이 놓여 있다.
 * <p>
 * 말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데, 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다. 즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.
 * <p>
 * 좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지를 구하는 프로그램을 작성하시오. 말이 지나는 칸은 좌측 상단의 칸도 포함된다.
 */
public class Main {

    static int R, C;
    static int[][] map;
    static boolean[] visit = new boolean[26];
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int ans = 0;

    public static void dfs(int x, int y, int count) {
        if (visit[map[x][y]]) { // 0,0에 저장된 알파벳이 이미 한번 방문한 알파벳이라면,
            ans = Math.max(ans, count); // 정답을 갱신해준다.
            return; // 조건에 만족하므로 리턴.
        } else {
            visit[map[x][y]] = true;
            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx >= 0 && cy >= 0 && cx < R && cy < C) {
                    dfs(cx, cy, count + 1);
                }

            }

            visit[map[x][y]] = false;

        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }

        dfs(0, 0, 0);
        // (0,0)부터 시작하며, 현재 이동한 위치는 0회

        System.out.println(ans);
    }
}

