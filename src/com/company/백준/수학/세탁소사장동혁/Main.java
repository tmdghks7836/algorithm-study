package com.company.백준.수학.세탁소사장동혁;

import java.util.Scanner;

public class Main {

    /**
     * $0.5달러를 줘야하는 경우에 거스름돈으로 $5달러를 주는것이다!
     * 어쩔수 없이 뛰어난 코딩 실력을 발휘해 리암을 도와주는 프로그램을 작성하려고 하지만, 디아블로를 하느라 코딩할 시간이 없어서 이 문제를 읽고 있는 여러분이 대신 해주어야 한다.
     */
    public void solution() {

        Scanner sc = new Scanner(System.in);


        int num = sc.nextInt();

        int T = 2;
        int value = 0;
        int beforeSum = 0;
        while (true) {

            value += T - 1;

            if (num <= value) {
                break;
            }

            beforeSum = value;

            T++;
        }

        value -= beforeSum;
        num -= beforeSum;

        int parent = 0;
        int child = 0;
        if (T % 2 == 0) { //올라가기
            child = (value - (num - 1));
            parent = num ;
        } else { //내려가기
            parent = (value - (num - 1));
            child = num ;
        }

        System.out.println(child + "/" + parent);
    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}