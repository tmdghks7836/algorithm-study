package com.company.대기업유제.DP.팰린드롬;

import java.util.Scanner;

public class Main {


    /**
     * {1}, {1, 2, 1}, {1, 2, 2, 1}과 같은 수열은 팰린드롬 이지만, {1, 2, 3}, {1, 2, 3, 2}
     */
    public void solution() {

        Scanner sc = new Scanner(System.in);

        int valueCnt = sc.nextInt();

        if(valueCnt == 0) {
            System.out.println(0);
            return;
        }

        int[] values = new int[valueCnt + 1];

        for (int i = 1; i < values.length; i++) {
            values[i] = sc.nextInt();
        }

        int[][] space = new int[valueCnt + 1][valueCnt + 1];
        int minusI = 1;
        for (int j = 2; j < space.length; j++) {

            int tempJ = j;

            for (int i = 1; i < space.length - minusI; i++) {

                //만약 같다면 i+1 j-1에 대한 값을 대입
//                System.out.println(i + " : " + tempJ);
                if (values[i] == values[tempJ]) {

                    space[i][tempJ] = space[i + 1][tempJ - 1];
                } else { //같지 않다면 둘 중 최소 조합갯수 + 1
                    space[i][tempJ] = Math.min(space[i][tempJ - 1], space[i + 1][tempJ]) + 1;
                }

                tempJ++;
            }
            minusI++;
        }

        System.out.println(space[1][space.length - 1]);
    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}