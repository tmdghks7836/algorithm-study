package com.company.etc.BFS.미로탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static Queue<Node> queue = new LinkedList<>();
    static int result = -1;

    public class Node {

        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public void BFS(int x, int y) {


        queue.offer(new Node(x, y));

        while (!queue.isEmpty()) {

            Node poll = queue.poll();

            for (int i = 0; i < 4; i++) {

                int newX = poll.x + dx[i];
                int newY = poll.y + dy[i];

                if (newX <= 0 || newY <= 0 || newX > 7 || newY > 7) continue;

                if (map[newY][newX] == 0) {

                    int step = map[poll.y][poll.x] + 1;

                    if (newX == 7 && newY == 7) {
                        result = step;
                        return;
                    }

                    map[newY][newX] = step;
                    //  System.out.print(newY + "," + newX + " ");
                    queue.offer(new Node(newX, newY));
                }
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

        T.BFS(1, 1);

        System.out.println(result);
    }
}
