package com.company._1배열.두배열합치기;

import java.util.Scanner;

/**
 * 1. 두 배열 합치기
 * 설명
 * <p>
 * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
 * <p>
 * <p>
 * 입력
 * 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
 * <p>
 * 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
 * <p>
 * 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
 * <p>
 * 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
 * <p>
 * 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
 * <p>
 * <p>
 * 출력
 * 오름차순으로 정렬된 배열을 출력합니다.
 * <p>
 * <p>
 * 예시 입력 1
 * <p>
 * 3
 * 1 3 5
 * 5
 * 2 3 6 7 9
 */
public class Main {

    public String solution(Integer[] firstArr, Integer[] secondArr) {


        int totalLength = firstArr.length + secondArr.length;
        int firstPos = 0;
        int secondPos = 0;

        int[] result = new int[totalLength];

        for (int i = 0; i < result.length; i++) {

            if (firstArr[firstPos] < secondArr[secondPos]) {

                result[i] = firstArr[firstPos];
                firstArr[firstPos] = Integer.MAX_VALUE;
                if(firstPos < firstArr.length - 1){
                    firstPos++;
                }
            } else {
                result[i] = secondArr[secondPos];
                secondArr[secondPos] = Integer.MAX_VALUE;
                if(secondPos < secondArr.length -1){
                    secondPos++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append(" ");
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        Integer first = in.nextInt();

        Integer[] firstArr = new Integer[first];

        for (int i = 0; i < firstArr.length; i++) {

            firstArr[i] = in.nextInt();
        }

        Integer second = in.nextInt();

        Integer[] secondArr = new Integer[second];

        for (int i = 0; i < secondArr.length; i++) {

            secondArr[i] = in.nextInt();
        }
        System.out.println(T.solution(firstArr, secondArr));
    }
}
