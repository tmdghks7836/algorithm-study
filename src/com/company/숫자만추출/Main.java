package com.company.숫자만추출;

import java.util.Scanner;


public class Main {

    public long solution(String str) {

        long answer = 0;
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            if(chars[i] >= 48 && chars[i] <= 57){
                answer = answer * 10 + (chars[i] - 48);
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
