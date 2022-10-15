package com.company._0문자.팰린드룸;

import java.util.Scanner;


public class Main {

    public String solution(String str) {

        String s = str.toUpperCase().replaceAll("[^A-Z]", "");

        String after = new StringBuilder().append(s).reverse().toString();

        if (!s.equals(after)) {

            return "NO";
        }
        return "YES";
    }


    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        String next = in.nextLine();


        System.out.println(T.solution(next));
    }
}
