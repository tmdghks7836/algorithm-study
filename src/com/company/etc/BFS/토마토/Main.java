package com.company.etc.BFS.토마토;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static Queue<Node> queue = new LinkedList<>();
    static int result = -1;
    static int n, m, tomatoCnt;

    static public class Node {

        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public void BFS() {


        while (!queue.isEmpty()) {

            Node poll = queue.poll();

            for (int i = 0; i < 4; i++) {

                int newX = poll.x + dx[i];
                int newY = poll.y + dy[i];

                if (newX < 0 || newY < 0 || newX >= map[0].length || newY >= map.length) continue;

                if (map[newY][newX] == 0) {

                    int step = map[poll.y][poll.x] + 1;

                    map[newY][newX] = step;
                    tomatoCnt--;

                    if(tomatoCnt == 0){
                        result = step - 1;
                        return;
                    }
                    //  System.out.print(newY + "," + newX + " ");
                    queue.offer(new Node(newX, newY));
                }
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        m = in.nextInt();
        n = in.nextInt();
        map = new int[n][m];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {

                int i1 = in.nextInt();

                if(i1 == 0){
                    tomatoCnt++;
                }
                if(i1 == 1){
                    queue.offer(new Node(j, i));
                }

                map[i][j] = i1;
            }
        }

        T.BFS();

        System.out.println(result);
    }
}
