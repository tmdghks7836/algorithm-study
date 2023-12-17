package com.company.백준.DP.수도배관공사;

import java.util.Scanner;

public class Main {


    /**
     * 거리 7 <= D <= 100000 떨어진 강에서 물을 끌어고기로 함
     * 근처 인간마을에서 P개  1 <= P <= 350 의 파이프를 매입, 길이 L(i) 용량 C(i) , 각각 같거나 223보다  작을 수 있음
     * 파이프들을 일렬로 이어 수도관 하나로 만듦. 파이프들의 용량 중 최솟값, 수도관의 길이는 파이프들 길이의 총합
     * 수도관을 한개 만들어 총 길이가 정확히 D와 같게 할때 가능한 최대 수도관 용량을 구하는 법
     */
    public void solution() {

        Scanner sc = new Scanner(System.in);
        int totalLength = sc.nextInt();
        int pipeCnt = sc.nextInt();

        if (pipeCnt == 0) {
            System.out.println(0);
            return;
        }

        int[] lengths = new int[pipeCnt + 1];
        int[] weights = new int[pipeCnt + 1];

        for (int i = 1; i < lengths.length; i++) {
            lengths[i] = sc.nextInt(); //길이
            weights[i] = sc.nextInt(); //용량
        }

        int[][] space = new int[pipeCnt + 1][totalLength + 1];

        for (int j = 1; j < totalLength; j++) {

            //첫번째와 1~7 중 같은 숫자가 있으면
            if (lengths[1] == j) {
                space[1][j] = weights[1];
            }
        }

        for (int i = 2; i < space.length; i++) {

            for (int j = totalLength; j > 0; j--) {

                int beforeJ = j - lengths[i]; // 5-2 = 3

                if (beforeJ < 0) {
                    space[i][j] = space[i - 1][j];
                    continue;
                }

                if (beforeJ == 0) {
                    space[i][j] = Math.max(weights[i], space[i - 1][j]);
                    continue;
                }

                if (space[i - 1][beforeJ] == 0) { // 6
                    space[i][j] = space[i - 1][j];
                    continue;
                }

                int min = Math.min(space[i - 1][beforeJ], weights[i]);

                if (space[i - 1][j] == 0) {
                    space[i][j] = min;
                    continue;
                }
                space[i][j] = Math.max(min, space[i - 1][j]);
            }
        }

//        for (int i = 0; i < space.length; i++) {
//            System.out.println(Arrays.toString(space[i]));
//        }
        System.out.println(space[space.length - 1][space[0].length - 1]);
    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}