package com.company.etc._1배열.에라토스테네스체;

import java.util.Scanner;

/**
 * 에라토스테네스의 체
 * 기본적인 알고리즘방식은 알고있지만 2중 for문을 돌릴때 time limit exceed 가 나왓다
 * j를 하나씩 ++해서 for문을 돌리는 것이아니라 애초에 i의 배수만 체크하는 것이므로 j = j + i 를 하면서 for문을 돌리는 것이 시간 절약이 된다.
 * */
public class Main {

    public Integer solution(Integer num) {

        int[] pill = new int[num + 1];

        int result = 0;

        for (int i = 2; i < pill.length; i++) {

            if (pill[i] == 0) {
                result++;
            }

            for (int j = i; j < pill.length; j = j + i) {

                pill[j] = 1;
            }

        }

        return result;
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        Integer integer = in.nextInt();


        System.out.println(T.solution(integer));
    }
}
