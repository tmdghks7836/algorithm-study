package com.company.백준.greedy.거스름돈;

import java.util.Scanner;

public class Main {


    public void solution() {

        Scanner sc = new Scanner(System.in);

        int coin = sc.nextInt();

        /**
         * 13에 대해서
         * 2 5
         * 5로 나눈 나머지가 짝수가 되게 해야한다.
         * 13 % 5 % 2 != 0
         *
         * */
        int temp = coin;

        int coin5 = temp / 5;
        temp = temp % 5;
        //13 % 5 % 2 == 1
        if (coin >= 5 && coin % 5 % 2 != 0) {
            // 1
            coin5--;
            temp += 5;
        }

        if(temp % 2 != 0){
            System.out.println(-1);
            return;
        }

        temp = temp / 2;
        System.out.println(temp + coin5);
    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}