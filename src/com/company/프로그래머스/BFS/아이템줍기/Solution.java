package com.company.프로그래머스.BFS.아이템줍기;


public class Solution {

    public enum Direction {
        LEFT(0, -1), RIGHT(0, +1), UP(1, 0), DOWN(-1, 0);

        int yd, xd;

        Direction(int yd, int xd) {
            this.yd = yd;
            this.xd = xd;
        }

        public Node move(Node node) {

            Node node1 = new Node(node.y + yd, node.x + xd);
            System.out.println(node1);
            return node1;
        }

    }

    int[][] rectangles;
    int itemX, itemY;
    Node leftNode, rightNode;

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }

    public int BFS(int cy, int cx) {

        int result = 0;
        leftNode = new Node(cy, cx);
        rightNode = new Node(cy, cx);
        while (true) {

            if (leftNode.x == itemX && leftNode.y == itemY) {
                System.out.println("왼쪽");
                return result;
            }
            if (rightNode.x == itemX && rightNode.y == itemY) {
                return result;
            }

            Direction ld = getLeftDirection(leftNode.y, leftNode.x);
            Direction rd = getRightDirection(rightNode.y, rightNode.x);

            leftNode = ld.move(leftNode);
            rightNode = rd.move(rightNode);
            result++;
        }
    }

    public Direction left(int y, int x, int[] current) {

        int x1 = current[0]; //1
        int y1 = current[1]; //1
        int x2 = current[2]; //7
        int y2 = current[3];

        if (y == y1 && x > x1 && x <= x2) {
            return Direction.LEFT;
        } else if (y == y2 && x >= x1 && x < x2) {
            return Direction.RIGHT;
        } else if (y >= y1 && y < y2 && x == x1) {
            return Direction.UP;
        } else if (y > y1 && y <= y2 && x == x2) {
            return Direction.DOWN;
        }

        return null;
    }

    public Direction right(int y, int x, int[] current) {

        int x1 = current[0]; //1
        int y1 = current[1]; //1
        int x2 = current[2]; //7
        int y2 = current[3];

        if (y == y1 && x >= x1 && x < x2) {
            return Direction.RIGHT;
        } else if (y == y2 && x > x1 && x <= x2) {
            return Direction.LEFT;
        } else if (x == x1 && y > y1 && y <= y2) {
            return Direction.DOWN;
        } else if (x == x2 && y >= y1 && y < y2) {
            return Direction.UP;
        }

        return null;
    }

    public Direction getLeftDirection(int y, int x) {

        Direction direction = null;

        for (int i = 0; i < rectangles.length; i++) {

            int x1 = rectangles[i][0]; //1
            int y1 = rectangles[i][1]; //1
            int x2 = rectangles[i][2]; //7
            int y2 = rectangles[i][3]; //4

            if ((y >= y1 && y <= y2 && (x == x1 || x == x2)) || (x >= x1 && x <= x2 && (y == y1 || y == y2))) {

                Direction lD = left(y, x, rectangles[i]);
                if (direction == null) {
                    direction = lD;
                } else if (direction == Direction.LEFT && lD == Direction.DOWN) {
                    direction = lD;
                } else if (direction == Direction.UP && lD == Direction.LEFT) {
                    direction = lD;
                } else if (direction == Direction.RIGHT && lD == Direction.UP) {
                    direction = lD;
                } else if (direction == Direction.DOWN && lD == Direction.RIGHT) {
                    direction = lD;
                }
            }
        }

        return direction;
    }

    public Direction getRightDirection(int y, int x) {

        Direction direction = null;

        for (int i = 0; i < rectangles.length; i++) {

            int x1 = rectangles[i][0]; //1
            int y1 = rectangles[i][1]; //1
            int x2 = rectangles[i][2]; //7
            int y2 = rectangles[i][3]; //4

            if ((y >= y1 && y <= y2 && (x == x1 || x == x2)) || (x >= x1 && x <= x2 && (y == y1 || y == y2))) {

                Direction lD = right(y, x, rectangles[i]);
                if (direction == null) {
                    direction = lD;
                } else if (direction == Direction.RIGHT && lD == Direction.DOWN) {
                    direction = lD;
                } else if (direction == Direction.DOWN && lD == Direction.LEFT) {
                    direction = lD;
                } else if (direction == Direction.LEFT && lD == Direction.UP) {
                    direction = lD;
                } else if (direction == Direction.UP && lD == Direction.RIGHT) {
                    direction = lD;
                }
            }
        }

        return direction;
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        this.rectangles = rectangle;
        this.itemX = itemX;
        this.itemY = itemY;
        return BFS(characterY, characterX);
    }
}