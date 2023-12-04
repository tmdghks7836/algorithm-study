package com.company.etc._1배열.뒤집은_소수;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 설명
 *
 * N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
 *
 * 예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
 *
 * 첫 자리부터의 연속된 0은 무시한다.
 *
 *
 * 입력
 * 첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
 *
 * 각 자연수의 크기는 100,000를 넘지 않는다.
 *
 *
 * 출력
 * 첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.
 *
 * 9
 * 32 55 62 20 250 370 200 30 100
 *
 * 23 2 73 2 3
 * */
public class Main {

    public String solution(int[] arr) {

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {

            StringBuilder sb = new StringBuilder();
            String reverseStr = sb.append(arr[i]).reverse().toString();

            int reverseInt = Integer.parseInt(reverseStr);

            if(isPrime(reverseInt)){
                result.add(reverseInt);
            }
        }

        return String.join(" ", result.stream().map(integer -> integer.toString()).collect(Collectors.toList()));
    }

    private boolean isPrime(int reverseInt) {
        if(reverseInt == 1){
            return false;
        }

        for (int i1 = 2; i1 < reverseInt; i1++) {

            if(reverseInt % i1 == 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        Integer integer = in.nextInt();

        int[] arr = new int[integer];

        for (int i = 0; i < integer; i++) {

            arr[i] = in.nextInt();
        }
        System.out.println(T.solution(arr));
    }
}
