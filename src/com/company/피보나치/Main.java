package com.company.피보나치;

import java.util.Scanner;


public class Main {
                         //n = 5
    public void solution(int n) {
                                   // 0 1 2 3 4
        int[] answer = new int[n]; //{1,1,2,3,5}

        answer[0] = 1;
        answer[1] = 1;

        for (int i = 2; i < answer.length; i++) {
            answer[i] = answer[i -2] + answer[i -1];
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        int next = in.nextInt();

        T.solution(next);
    }
}
