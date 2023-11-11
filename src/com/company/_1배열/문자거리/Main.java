package com.company._1배열.문자거리;

import java.util.Scanner;


public class Main {

    public String solution(String str) {

        String[] s = str.split(" ");
        char division = s[1].charAt(0);
        char[] chars = s[0].toCharArray();
        int[] proceed = new int[chars.length];

        int value = 9999;

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == division) {
                value = 0;
                proceed[i] = value;
            } else {
                value++;
                proceed[i] = value;
            }
        }

        value = 9999;

        for (int i = chars.length - 1; i >= 0; i--) {

            if (chars[i] == division) {
                value = 0;
            } else {
                value++;
                proceed[i] = Math.min(value, proceed[i]);
            }
        }

        for (int i : proceed) {
            System.out.print(i + " ");
        }

        return "";
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        String next = in.nextLine();


        System.out.println(T.solution(next));
    }
}
