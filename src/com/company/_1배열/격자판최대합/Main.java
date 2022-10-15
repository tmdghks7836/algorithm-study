package com.company._1배열.격자판최대합;

import java.util.Scanner;

/**
 * 5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
 * <p>
 * <p>
 * N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
 * <p>
 * <p>
 * 입력
 * 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
 * <p>
 * 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
 * <p>
 * <p>
 * 출력
 * 최대합을 출력합니다.
 * <p>
 * <p>
 * 예시 입력 1
 * <p>
 * 5
 * 10 13 10 12 15
 * 12 39 30 23 11
 * 11 25 50 53 15
 * 19 27 29 37 27
 * 19 13 30 13 19
 * 예시 출력 1
 * <p>
 * 155
 */
public class Main {

    public Object solution(Integer[][] arr2) {

        Integer answer = 0;
        Integer case3 = 0;
        Integer case4 = 0;

        for (int i = 0; i < arr2.length; i++) {

            Integer x = 0, y = 0;
            for (int j = 0; j < arr2.length; j++) {

                x += arr2[i][j];
                y += arr2[j][i];
            }
            answer = Math.max(answer, x);
            answer = Math.max(answer, y);
        }

        for (int i = 0; i < arr2.length; i++) {

            case3 += arr2[i][i];
            case4 += arr2[i][arr2.length - 1 - i];
        }
        answer = Math.max(answer, case3);
        answer = Math.max(answer, case4);
        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        Integer next = in.nextInt();

        Integer[][] arr2 = new Integer[next][next];

        for (int i = 0; i < arr2.length; i++) {

            for (int j = 0; j < arr2.length; j++) {
                arr2[i][j] = in.nextInt();
            }
        }
        System.out.println(T.solution(arr2));
    }
}
