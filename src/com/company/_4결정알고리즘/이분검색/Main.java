package com.company._4결정알고리즘.이분검색;

import java.util.*;

/**
 * 숫자를 재귀를 통해 이진수로 표현하기
 */
public class Main {


    public Object solution(int target) {

        divide(target);
        return "";
    }

    public void divide(int num){

        if(num == 0) return;

        System.out.print(num % 2 + " ");
        divide(num / 2 );
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        int target = in.nextInt();

        System.out.println(T.solution(target));
    }
}
