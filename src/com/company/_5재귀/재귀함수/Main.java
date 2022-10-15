package com.company._5재귀.재귀함수;

import java.util.Scanner;


public class Main {


    public Object solution(int target) {

        recursion(target);
        return "";
    }

    public void recursion(int target){

        if(target > 1 ) {
            recursion(target - 1);
        }

        System.out.print(target + " ");
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);


        int target = in.nextInt();

        System.out.println(T.solution(target));
    }
}
