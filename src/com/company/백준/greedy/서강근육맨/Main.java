package com.company.백준.greedy.서강근육맨;

import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public void solution() {

        Scanner sc = new Scanner(System.in);

        int equipmentCnt = sc.nextInt();

        long[] equipments = new long[equipmentCnt];

        for (int i = 0; i < equipments.length; i++) {
            equipments[i] = sc.nextLong();
        }

        if(equipmentCnt == 1) {
            System.out.println(equipments[0]);
            return;
        }

        Arrays.sort(equipments);

        int left = 0;
        int right = equipmentCnt -1;

        long max;

        if(equipmentCnt % 2 == 0){
            max = equipments[right] + equipments[left];
            left++;
        }else{
            max = equipments[right];
        }
        right--;

        while(left < right){

            long equipmentR = equipments[right];
            long equipmentL = equipments[left];
            if(equipmentR + equipmentL > max){
                max = equipmentR + equipmentL;
            }
            left++;
            right--;

        }

        System.out.println(max);
        /**
         *
         * PT 한번 받을 때 운동기구 최대 2개까지 선택
         * N개의 운동기구 하나씩 사용해보고싶다. PT를 받을 때마다 이전에 사용하지 않았던 운동기구 선택하고싶다.
         * PT받을때 최소 2개 사용.
         * 10개 기구있을 때 pt 5번 받으면 모든 기구 사용가능
         * 10개 기구있을 때 pt 5번 받으면 모든 기구 사용가능 , 마지막에는 1개의 운동기구
         * 자극이 낮으면 근손실 적게, 자극이 높으면 근손실 많이
         * PT한번 받을 때 근손실 정도가 M을 넘지 않도록 M의 최솟값 구하기
         * 근손실 : 운동기구 1 or 2 개의 근손실 정도 합
         *
         * 5 -> 운동개구 갯수
         * */
    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}