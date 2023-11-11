package com.company._1배열.봉우리;

import java.util.Scanner;


public class Main {

    Integer[] xx = new Integer[]{-1, 0, 1, 0};
    Integer[] yy = new Integer[]{0, -1, 0, 1};

    public Integer solution(Integer[][] arr) {

        Integer result = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {

                if (isMountain(arr, i, j)) {
                    result++;
                }
            }
        }

        return result;
    }

    public Boolean isMountain(Integer[][] arr, Integer i, Integer j) {

        for (int k = 0; k < 4; k++) {

            int x = i + xx[k];
            int y = j + yy[k];

            if (x >= 0 && x < arr.length && y >= 0 && y < arr.length) {
                if (arr[i][j] <= arr[x][y]) {
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        Integer next = in.nextInt();

        Integer[][] arr = new Integer[next][next];

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(T.solution(arr));
    }
}
