package com.company.etc._5재귀.팩토리얼;

import java.util.Scanner;


public class Main {


    public Object solution(int target) {

        return recursion(target);
    }

    public int recursion(int target){

        if(target <= 1) return target;

        int recursion = recursion(target - 1);

        return recursion * target;
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);


        int target = in.nextInt();

        System.out.println(T.solution(target));
    }
}
