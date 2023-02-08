package com.company.백준.DFSBFS.사다리조작;


import java.util.Scanner;

public class Main {

    static int[][] area;
    static boolean[][] check;
    static boolean[] moveYCheck;
    static int count = 0;
    static int 가로길이;
    static int 세로길이;
    static int target;

    public static boolean DFS(int y, int x) {

        if (y == 세로길이) {
            return checkLast(x);
        }

        if (canMove(y, x - 1)) {
            x--;
        } else if (canMove(y, x)) {
            x++;
        }

        moveYCheck[y] = true;

        int next = y + 1;

        if (DFS(next, x)) return true;

        if (target < x && canBuild(y, x - 1)) {
            check[y][x - 1] = true;
            DFS(y, x - 1);
            check[y][x - 1] = false;
        }

        if (target > x && canBuild(y, x)) {
            check[y][x] = true;
            DFS(y, x);
            check[y][x] = false;
        }

        return false;
    }

    //마지막으로 갔는지?
    public static boolean checkLast(int x) {

        if (target == x) {
            System.out.println("같은곳에 도착한 : " + (target + 1));
            return true;

        } else {
            System.out.println("같은곳에 도착하지 못한 : " + (target + 1) + " 결과지점 : " + (x + 1));
            return false;
        }
    }

    //오른쪽 왼쪽으로 갈 수 있는지?
    public static boolean canMove(int y, int x) {

        if (isIn(y, x) && !moveYCheck[y]) return check[y][x];

        return false;
    }

    //범위 안에 있는지?
    public static boolean xIsIn(int x) {

        return x >= 0 && x < 가로길이;
    }

    //범위 안에 있는지?
    public static boolean yIsIn(int y) {

        return y >= 0 && y < 세로길이;
    }

    //범위 안에 있는지?
    public static boolean isIn(int y, int x) {

        return yIsIn(y) && xIsIn(x);
    }

    //다리를 놓을 수 있는지?
    public static boolean canBuild(int y, int x) {


        if (!isIn(y, x) || check[y][x]) return false;

        int left = x - 1;
        int right = x;

        //범위 안에 존재하고
        if (xIsIn(left)) {
            //왼쪽에 다리가 있으면
            if (canMove(y, left)) {
                return false;
            }
        }

        //범위 안에 존재하고
        if (xIsIn(right)) {
            //오른쪽에 다리가 있으면
            if (canMove(y, right)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        가로길이 = in.nextInt();
        int H = in.nextInt();
        세로길이 = in.nextInt();
        area = new int[세로길이][가로길이];
        check = new boolean[세로길이][가로길이];
        moveYCheck = new boolean[세로길이];

        for (int i = 0; i < H; i++) {
            //해당 곳에는 다리가 놓여져 있다.
            int y = in.nextInt() - 1;
            int x = in.nextInt() - 1;
            check[y][x] = true;
        }

        for (int i = 0; i < 1; i++) {

            target = i;
            DFS(0, i);
        }

    }
}