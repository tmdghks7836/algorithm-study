package com.company.etc.프로그래머스.etc.단계1;

public class 약수의합 {

    public double solution(int[] arr) {
        double answer = 0;

        for (int i = 0; i < arr.length; i++) {

            answer += arr[i];
        }

        return answer / arr.length;
    }

}