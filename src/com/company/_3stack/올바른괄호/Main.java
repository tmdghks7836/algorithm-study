package com.company._3stack.올바른괄호;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public String solution(String next) {

        Stack<Character> stack = new Stack<>();

        for (Character c : next.toCharArray()) {

            if (c.equals('(')) {
                stack.add(c);
            } else {
                try {
                    stack.pop();
                } catch (Exception e) {
                    return "NO";
                }
            }
        }

        return stack.size() > 0 ? "NO" : "YES";
    }


    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        String next = in.next();

        System.out.println(T.solution(next));
    }
}
