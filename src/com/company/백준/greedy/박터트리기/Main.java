package com.company.백준.greedy.박터트리기;

import java.util.Scanner;

public class Main {


    public void solution() {

        Scanner sc = new Scanner(System.in);

        /**
         * K개의 팀이 박터트리기
         * 각 팀은 한의 바구니에 들어있는 공을 던져서 자기팀의 박을 터뜨려야한다.
         * N: 공의 갯수
         * K: 바구니 갯수
         * 공을 바구니에 다르게 나눠담는다.
         * 빠짐없이 담는다.
         * 바구니는 1개이상의 공이 있고 달라야함
         * 많이 담긴 바구니, 적게담긴 바구니 개수 차이 최소
         *
         *
         * */

        int ball = sc.nextInt();
        int basket = sc.nextInt();

        int[] baskets = new int[basket];

        for (int i = 0; i < baskets.length; i++) {

            if (ball - (i + 1) >= 0) {
                baskets[i] = i + 1;
                ball -= i + 1;
            } else {
                System.out.println(-1);
                return;
            }
        }

        while(ball > 0){

            for (int i = baskets.length - 1; i >= 0; i--) {

                if (ball -1 >= 0) {
                    baskets[i]++;
                    ball--;
                }else{
                    break;
                }
            }
        }



        System.out.println(baskets[baskets.length -1] - baskets[0]);

    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}