package com.company.프로그래머스.단계1;

import java.util.HashMap;
import java.util.Map;

public class 약수의합 {

    public double solution(int[] arr) {
        double answer = 0;

        for (int i = 0; i < arr.length; i++) {

            answer += arr[i];
        }

        return answer / arr.length;
    }

}