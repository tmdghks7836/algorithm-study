package com.company.etc._1배열.교육과정설계;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;


public class Main {

    public String solution(String required, String educations) {

        Queue<Character> queue = new ArrayDeque<>();

        char[] chars = required.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            queue.offer(chars[i]);
        }

        char[] chars1 = educations.toCharArray();

        for (int i = 0; i < chars1.length; i++) {

            Character education = chars1[i];
            if (education.equals(queue.peek())) {
                queue.poll();
            }
        }


        return queue.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        String next = in.next();

        String next2 = in.next();
        System.out.println(T.solution(next, next2));
    }
}
