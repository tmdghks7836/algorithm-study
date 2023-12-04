package com.company.etc._3stack.쇠막대기;

import java.util.Scanner;
import java.util.Stack;


public class Main {

    char[] chars;
    Stack<Character> stack = new Stack<>();

    public int solution(String str) {

        chars = str.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {

            Character cc = chars[i];
            if(cc == '('){
                stack.add(cc);
            }else{
                stack.pop();
                if(chars[i - 1] == '('){
                    result += stack.size();
                }else{
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        String next = in.next();


        System.out.println(T.solution(next));
    }
}
