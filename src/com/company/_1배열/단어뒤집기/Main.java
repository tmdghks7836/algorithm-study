package com.company._1배열.단어뒤집기;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public String solution(String[] strings) {

        ArrayList<String> answer = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {

           StringBuilder sb = new StringBuilder();
            for (int j = strings[i].length() - 1; j >= 0   ; j--) {

                sb.append(strings[i].charAt(j));
            }

            answer.add(sb.toString());
        }

        StringBuilder sb2 = new StringBuilder();

        answer.forEach(s -> sb2.append(s).append("\n"));
        return sb2.toString();
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        Integer num = in.nextInt();

        String[] strings = new String[num];

        for (int i = 0; i < num; i++) {
             strings[i] = in.next();
        }

        System.out.println(T.solution(strings));

    }
}
