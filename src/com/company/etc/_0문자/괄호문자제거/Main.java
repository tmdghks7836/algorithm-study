package com.company.etc._0문자.괄호문자제거;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public String solution(String next) {

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (Character c : next.toCharArray()) {

            if (c.equals('(')) {
                stack.add(c);
            } else if (c.equals(')')) {
                stack.pop();
            } else {

                if (stack.size() == 0) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        String next = in.next();

        System.out.println(T.solution(next));
    }
}
