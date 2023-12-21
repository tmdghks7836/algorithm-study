package com.company.백준.DFSBFS.적록색약;

import java.util.*;

public class Main {

    public void solution() {

        /**
         *
         *  N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다
         *   색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다
         * */
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        char[][] normalArr = new char[N][N];
        char[][] nNormalArr = new char[N][N];

        for (int i = 0; i < N; i++) {

            char[] charArray = sc.next().toCharArray();
            for (int j = 0; j < charArray.length; j++) {

                char c = charArray[j];
                normalArr[i][j] = c;
                if (c == 'R' || c == 'G')
                    nNormalArr[i][j] = 'K';
            }
        }

        extracted(normalArr, new boolean[N][N]);
        extracted(nNormalArr, new boolean[N][N]);
    }

    private void extracted(char[][] arr, boolean[][] ch) {
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {

                if (ch[i][j]) continue;
                ch[i][j] = true;

                cnt++;
                DFS(j, i, ch, arr);
            }
        }

        System.out.print(cnt + " ");
    }

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};

    private void DFS(int x, int y, boolean[][] ch, char[][] arr) {

        for (int i = 0; i < 4; i++) {

            int moveX = dx[i] + x;
            int moveY = dy[i] + y;

            if (moveX < 0 || moveY < 0 || moveX >= arr[0].length || moveY >= arr.length) continue;
            if (arr[moveY][moveX] != arr[y][x]) continue;
            if (ch[moveY][moveX]) continue;
            ch[moveY][moveX] = true;

            DFS(moveX, moveY, ch, arr);
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}