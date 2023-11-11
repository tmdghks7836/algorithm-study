package com.company.문자열압축;

import java.util.Scanner;


public class Main {
    //KKHSSSSSSSE
    public String solution(String str) {

        char[] chars = str.concat(" ").toCharArray();

        char cur = chars[0];
        int idx = 0;
        String answer = "" + cur;
        for (int i = 0; i < chars.length; i++) {

            if (cur != chars[i]) {
                if (idx > 1) {
                    answer += idx;
                }
                idx = 0;
                cur = chars[i];
                answer += chars[i];
            }
            idx++;
        }


        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        String next = in.next();


        System.out.println(T.solution(next));
    }
}
