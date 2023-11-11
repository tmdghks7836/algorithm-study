package com.company.암호;

import java.util.Scanner;


//4
//#****###**#####**#####**##**
public class Main {
    public void solution(int n, String str) {


        String answer = "";

        for (int i = 0; i < n; i++) {

            String substring = str.substring(0, 7);
            str = str.substring(7);

            String replace = substring.replace("#", "1").replace("*", "0");
            char cc = (char)Integer.parseInt(replace, 2);

            System.out.print(cc);
        }
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        String next = in.next();

        T.solution(n, next);
    }
}
