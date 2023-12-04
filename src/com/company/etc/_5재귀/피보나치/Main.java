package com.company.etc._5재귀.피보나치;

import java.util.Scanner;


public class Main {

    static int[] mem;

    public Object solution(int target) {

        int recursion = recursion(target);

        return recursion;
    }

    public int recursion(int target) {

        if (mem[target] > 0) return mem[target];
        if (target <= 2) return 1;
        else return mem[target] = recursion(target - 1) + recursion(target - 2);
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);


        int target = in.nextInt();
        mem = new int[target + 1];

        for (int i = 0; i <= target; i++) {

            System.out.println(T.solution(i));
        }
    }
}
