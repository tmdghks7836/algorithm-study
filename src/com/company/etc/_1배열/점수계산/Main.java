package com.company.etc._1배열.점수계산;

import java.util.Scanner;


public class Main {

    public Object solution(Integer[] numArr) {

        Integer result = 0;
        Integer base = 1;
        for (int i = 0; i < numArr.length; i++) {

            if(numArr[i] == 1){

                result += base;
                base++;
            }else{
                base = 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        Integer next = in.nextInt();
        Integer[] arr = new Integer[next];

        for (Integer i = 0; i < next; i++) {

            arr[i] = in.nextInt();
        }
        System.out.println(T.solution(arr));
    }
}
