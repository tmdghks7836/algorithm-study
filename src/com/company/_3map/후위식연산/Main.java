package com.company._3map.후위식연산;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Main {

    public String solution(String str) {

        Set<Character> charset = new HashSet<>();

        char[] chars = str.toCharArray();
        String answer = "";
        for (int i = 0; i < chars.length; i++) {

            if (!charset.contains(chars[i])) {
                charset.add(chars[i]);
                answer += chars[i];
            }
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
