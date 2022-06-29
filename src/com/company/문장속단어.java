package com.company;

import java.util.Scanner;


public class 문장속단어 {

    public String solution(String str) {

        String answer = "";

        for (String word : str.split(" ")) {

            if(answer.length() < word.length()){
                answer = word;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        문장속단어 T = new 문장속단어();

        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        System.out.println(T.solution(str));

    }
}
