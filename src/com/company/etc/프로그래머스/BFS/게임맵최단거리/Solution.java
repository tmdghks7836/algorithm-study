package com.company.etc.프로그래머스.BFS.게임맵최단거리;


import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    Queue<Node> queue = new LinkedList<>();
    int[][] check;
    int[][] maps;
    int H, W;

    class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public int BFS() {

        queue.add(new Node(0, 0));
        check[0][0] = 1;

        while (!queue.isEmpty()) {

            Node poll = queue.poll();

            if (poll.x == W && poll.y == H) {
                return check[poll.y][poll.x];
            }

            for (int i = 0; i < 4; i++) {

                int newX = poll.x + dx[i];
                int newY = poll.y + dy[i];

                if (newX < 0 || newX > W || newY < 0 || newY > H) continue;
                if (check[newY][newX] != 0 || maps[newY][newX] == 0) continue;

                check[newY][newX] = check[poll.y][poll.x] + 1;
                queue.add(new Node(newY, newX));
            }

        }

        return -1;
    }

    public int solution(int[][] maps) {

        this.maps = maps;
        W = maps[0].length - 1;
        H = maps.length - 1;

        check = new int[H + 1][W + 1];
        return BFS();
    }

    public static void main(String[] args) {

        Solution T = new Solution();

        System.out.println(T.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
    }
}