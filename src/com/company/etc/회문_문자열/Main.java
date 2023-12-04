package com.company.etc.회문_문자열;

import java.util.Scanner;


public class Main {

    public String solution(String str) {

        char[] chars = str.toUpperCase().toCharArray();

        for (int i = 0; i < chars.length / 2; i++) {

            int lastIdx = chars.length - 1 - i;

            if (chars[i] != chars[lastIdx]) {
                return "NO";
            }
        }

        return "YES";
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        String next = in.next();


        System.out.println(T.solution(next));
    }
}
