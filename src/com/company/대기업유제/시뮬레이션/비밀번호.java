package com.company.대기업유제.시뮬레이션;

import java.util.Arrays;

public class 비밀번호 {

    public int solution(int[] keypad, String password){

        int answer = 0;
        int[] dx = {-1, -1, 0,1,1,1,0,-1};
        int[] dy = {0,1,1,1,0,-1,-1,-1};
        int[][] pad = new int[3][3];
        int[][] dist = new int[10][10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pad[i][j] = keypad[i * 3 + j];
            }
        }

        for (int i = 0; i < 10; i++) {
            Arrays.fill(dist[i], 2);
        }
        for (int i = 0; i < 10; i++) {
            dist[i][i] = 0;
        }
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                int from = pad[y][x];
                for (int k = 0; k < 8; k++) {
                    if(x+dx[k] >= 0 && x + dx[k] < 3 && y+dy[k] >= 0 && y + dy[k] < 3){
                        int to = pad[y + dy[k]][x + dx[k]];

                        dist[from][to] = 1;
                    }
                }
            }
        }

        char[] chars = password.toCharArray();

        for (int i = 0; i < chars.length -1; i++) {

            int from = Integer.parseInt(chars[i] + "");
            int to = Integer.parseInt(chars[i + 1] + "");

            answer += dist[from][to];
        }


        return answer;
    }

    public static void main(String[] args){
        비밀번호 T = new 비밀번호();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}