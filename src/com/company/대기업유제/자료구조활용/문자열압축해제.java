package com.company.대기업유제.자료구조활용;

import java.util.Collections;
import java.util.Stack;

class 문자열압축해제 {


    public String solution(String s) {
        String answer = "";

        Stack<String> st = new Stack<>();

        for (Character c : s.toCharArray()) {

            if (c == ')') {

                String tmp = "";

                while (!st.empty()) {

                    String pop = st.pop();
                    if (pop.equals("(")) {

                        String num = "";
                        while (!st.empty() && Character.isDigit(st.peek().charAt(0))) {
                            String pop1 = st.pop();
                            num = pop1;
                        }
                        String tmp2 = "";
                        int cnt;
                        if(num.equals("")) cnt = 1;
                        else cnt = Integer.valueOf(num);
                        for (Integer i = 0; i < cnt; i++) {
                            tmp2 += tmp;
                        }
                        st.push(tmp2);
                        break;
                    }
                    tmp = pop + tmp;
                }
            } else {
                st.push(String.valueOf(c));
            }
        }

        while (!st.empty()) {
            String pop = st.pop();
            answer = pop + answer;
        }

        return answer;
    }


    public static void main(String[] args) {
        문자열압축해제 T = new 문자열압축해제();
            System.out.println(T.solution("3(a2(b))ef"));
          System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
         System.out.println(T.solution("2(2(ab)3(2(ac)))"));
          System.out.println(T.solution("3(ab2(sg))"));
    }
}