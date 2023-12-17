package com.company.백준.greedy.블로그2;

import java.util.Scanner;

public class Main {


    public void solution() {

        Scanner sc = new Scanner(System.in);

        int i = sc.nextInt();

        String work = "";
        work = sc.next();

        int bCnt = 0;
        int rCnt = 0;
        char before = '-';
        for (int j = 0; j < i; j++) {

            if (before != work.charAt(j)) {

                if (work.charAt(j) == 'B') {
                    bCnt++;
                } else {
                    rCnt++;
                }
                before = work.charAt(j);
            }
        }


        System.out.println((Math.min(bCnt, rCnt)) + 1);

        /**
         * neighbor 블로그를 운영하는 일우는 매일 아침 풀고 싶은 문제를 미리 정해놓고 글을 올린다
         *  매일 밤 각각의 문제에 대하여, 해결한 경우 파란색, 해결하지 못한 경우 빨간색으
         *
         *  문제를 칠할 때
         *  연속된 임의의 문제들을 선택한다.
         *  선택된 문제들을 전부 원하는 같은 색으로 칠한다.
         *
         *  첫째 줄에 일우가 주어진 모든 문제를 원하는 색으로 칠할 때까지 필요한 작업 횟수
         * */
    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}