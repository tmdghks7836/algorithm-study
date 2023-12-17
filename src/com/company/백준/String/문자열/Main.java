package com.company.백준.String.문자열;

import java.util.Scanner;

public class Main {


    /**
     *
     */
    public void solution() {

        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();

        for (int i = 0; i < cnt; i++) {

            String next = sc.next();

            System.out.println(next.charAt(0) + "" + next.charAt(next.length() - 1));
        }


    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}