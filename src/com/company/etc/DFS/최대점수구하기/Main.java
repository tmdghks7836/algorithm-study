package com.company.etc.DFS.최대점수구하기;

import java.util.Scanner;


public class Main {

    static int quizNum, remainTime;
    static Quiz[] quizs;
    static int maxJum;

    public static class Quiz {

        int jumsu;
        int time;

        public Quiz(int jumsu, int time) {
            this.jumsu = jumsu;
            this.time = time;
        }
    }

    public void DFS(int index, int sum, int sumTime) {

        if(sumTime > remainTime){
            return;
        }

        if (index == quizNum) {

            maxJum = Math.max(maxJum, sum);
        } else {

            int i = index + 1;
            DFS(i, sum + quizs[index].jumsu,  sumTime + quizs[index].time);
            DFS(i, sum, sumTime);
        }

    }


    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);
        quizNum = in.nextInt();
        remainTime = in.nextInt();
        quizs = new Quiz[quizNum];

        for (int i = 0; i < quizNum; i++) {
            int jum = in.nextInt();
            int time = in.nextInt();
            quizs[i] = new Quiz(jum, time);
        }

        T.DFS(0, 0, 0);

        System.out.println(maxJum);
    }
}
