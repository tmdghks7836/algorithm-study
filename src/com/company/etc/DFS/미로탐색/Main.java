package com.company.etc.DFS.미로탐색;

import java.util.Scanner;


public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static int result = 0;

    public void DFS(int x, int y) {


        if (x == 7 && y == 7) {

            result++;
       //     System.out.println(result);
        } else {

            boolean dontGo = true;
            for (int i = 0; i < 4; i++) {

                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX <= 0 || newY <= 0 || newX > 7 || newY > 7) continue;

                if (map[newY][newX] == 0) {

                    dontGo = false;
                  //  System.out.print(newY + "," + newX + " ");
                    map[newY][newX] = 1;
                    DFS(newX, newY);
                    map[newY][newX] = 0;
                }
            }

            if(dontGo){
           //     System.out.println("더이상 갈수 없습니다.");
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        map = new int[8][8];

        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map.length; j++) {
                map[i][j] = in.nextInt();
            }
        }

        map[1][1] = 1;
        T.DFS(1, 1);

        System.out.println(result);
    }
}
