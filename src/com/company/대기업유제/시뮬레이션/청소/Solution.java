package com.company.대기업유제.시뮬레이션.청소;

import java.util.*;

/**
 * 청소로봇이 방을 청소하려고 합니다. 방은 n*n 격자판 지도로 표현됩니다. 방에는 장애물이 있고, 장애물이 있는 지점은 로봇이 지나갈 수 없습니다.
 * 로봇은 지도의 왼쪽 가장 위 격자에서 3시 방향(오른쪽)을 보고 있습니다. 로봇이 한 격자를 이동하는데 걸리는 시간은 1초입니다.
 * 로봇은 매초 한 칸씩 보고 있는 방향으로 이동합니다. 만약 지도 끝으로 이동해 더 이상 전진 할 수 없거나 또는 장애물을 만나면 제자리에서 시계방향으로 90도 회전합니다.
 * 회전하는데도 1초의 시간이 필요합니다.
 * 매개변수 board에 방의 지도정보가 주어지고, k에 초시간이 주어지면 로봇이 움직이기 시작해 서 k초 후에 멈춥니다. k초 후 로봇의 위치를 반환하는 프로그램을 작성하세요.
 */
class Solution {

    public enum Direction {

        LEFT(0, -1, "왼쪽"), UP(-1, 0, "위"), RIGHT(0, 1, "오른쪽"), DOWN(1, 0, "아래");

        int moveI;
        int moveJ;
        private String shape;

        Direction(int moveI, int moveJ, String shape) {
            this.moveI = moveI;
            this.moveJ = moveJ;

            this.shape = shape;
        }
    }


    public class Robot {

        int time;
        int i = 0;
        int j = 0;

        private Map<Direction, Direction> directionMap = new HashMap();

        private Direction currentDirection = Direction.RIGHT;

        public Robot(int k) {
            this.time = k;
            directionMap.put(Direction.LEFT, Direction.UP);
            directionMap.put(Direction.UP, Direction.RIGHT);
            directionMap.put(Direction.RIGHT, Direction.DOWN);
            directionMap.put(Direction.DOWN, Direction.LEFT);

        }

        public void move() {

            i += currentDirection.moveI;
            j += currentDirection.moveJ;
            System.out.println(currentDirection.shape);
            time--;
        }

        public int getFrontI() {

            return currentDirection.moveI + i;
        }

        public int getFrontJ() {

            return currentDirection.moveJ + j;
        }

        public void rotate() {

            currentDirection = directionMap.get(currentDirection);
            time--;
        }

        public boolean isDone() {
            return time == 0;
        }

        public boolean canMove(int[][] board) {

            int frontI = getFrontI();
            int frontJ = getFrontJ();

            if (frontJ < 0) return false;
            if (frontJ > board[0].length - 1) return false;

            if (frontI < 0) return false;
            if (frontI > board.length - 1) return false;

            if (board[getFrontI()][getFrontJ()] == 1) return false;

            return true;
        }

    }

    public int[] solution(int[][] board, int k) {

        int[] answer = new int[2];
        Robot robot = new Robot(k);

        while (true) {

            if (robot.canMove(board)) {
                robot.move();
            } else {
                robot.rotate();
            }

            if (robot.isDone()) {
                break;
            }
        }

        answer = new int[]{robot.i, robot.j};
        return answer;
    }


    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                        {0, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 1},
                        {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}