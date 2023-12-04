package com.company.etc._1배열.특정문자뒤집기;

import java.util.Scanner;


public class Main {

    public String solution(String str) {

        int lt = 0, rt = str.length() - 1;

        char[] chars = str.toCharArray();

        while (lt < rt) {

            if (!Character.isAlphabetic(chars[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(chars[rt])) {
                rt--;
            } else {
                char temp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = temp;
                lt++;
                rt--;
            }
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        String next = in.next();


        System.out.println(T.solution(next));
    }
}
