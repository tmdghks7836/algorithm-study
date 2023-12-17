package com.company.백준.DP.등차수열;

import java.util.Arrays;
import java.util.Scanner;

public class Main {


    /**
     * N개의 음 아닌 정수
     * 이 중 몇개의 정수를 선택 후 나열하면 등차수열 만들수있음
     * 4,3,1,5,7 -> 1,3,5,7을 선택하여 나열하면 등차수열이 된다.
     * 이 일정한 값은 음수나 0도 될 수 있다.
     */
    public void solution() {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        if (num == 1) {
            System.out.println(1);
            return;
        }
        int[][] space = new int[num + 1][num + 1];
        int[] numbers = new int[num + 1];


        for (int i = 1; i <= num; i++) {
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers);
        /**
         * 등차 = num[j] - num[i] 차이 구하기
         * num[i] - 등차 = k  i,j 의 값을 구하기 위해서는 (j값의 이전 등차 최대값 + 1을 해야한다.)
         * space[k][i] + 1
         *
         * */
        int result = 0;
        for (int i = 1; i < numbers.length - 1; i++) {

            for (int j = i + 1; j < numbers.length; j++) {

                space[i][j] = 2;

                //차이값을 구한다.
                int subtractedValue = numbers[j] - numbers[i];
                int pre = numbers[i] - subtractedValue;
                //i - 차이값을 했을 때 i 이전을 뒤져서 그 값이 있는지 확인한다.
                //있으면 이전 등차 최대값 + 1을 해준다.
                //등차가 0인 경우를 고려하여 1인덱스부터가 아닌 k-1부터 이전값으로 체크한다.
                for (int k = i - 1; k >= 1; k--) {

                    if (numbers[k] == pre) {
                        space[i][j] = space[k][i] + 1;
                        break;
                    }
                }

                result = Math.max(result, space[i][j]);
            }
        }

        System.out.println(result);
    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}