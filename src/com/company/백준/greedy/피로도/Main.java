package com.company.백준.greedy.피로도;

import java.util.Scanner;

public class Main {


    public void solution() {

        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();

        /**
         *
         * A : 피로도
         * B : 처리일
         * C : 회복
         * D : 피로도한계
         * */
        int time = 0;
        int work = 0;
        int tired = 0;
        while(time < 24){

            if(tired <= D - A){
                tired += A;
                work += B;
            } else{
                tired = Math.max(tired - C, 0);
            }

            time++;
        }

        System.out.println(work);
    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}