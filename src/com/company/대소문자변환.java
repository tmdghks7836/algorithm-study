package com.company;

import java.util.Scanner;


public class 대소문자변환 {

    public String solution(String str) {

        String answer = "";

        for (char c : str.toCharArray()) {

//            if(Character.isLowerCase(c)){
//                answer += Character.toUpperCase(c);
//            }else {
//                answer += Character.toLowerCase(c);
//            }
            if(c >= 65 && c <= 90){
               answer += (char)(c + 32);
            } else if(c >= 97 && c <= 122){
                answer += (char) (c - 32);
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        대소문자변환 T = new 대소문자변환();

        Scanner in = new Scanner(System.in);

        String str = in.next();

        System.out.println(T.solution(str));

    }
}
