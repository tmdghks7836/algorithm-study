package com.company.프로그래머스.N의최소공배수;

public class Solution {

    public int solution(int[] arr) {
        int answer = 0;

        //먼저 최대 공약수를 구한다.
        int gcd = gcd(arr[0], arr[1]);

        //최소 공배수를 구한다.
        answer = arr[0] * arr[1] / gcd;

        if(arr.length > 2){
            for (int i = 2; i < arr.length ; i++) {
                int gcd1 = gcd(answer, arr[i]);

                answer = (arr[i] * answer) / gcd1;
            }
        }


        return answer;
    }

    private static int gcd(int a, int b) {

        int i = a % b;

        if (i == 0) return b;

        return gcd(b, i);
    }

}