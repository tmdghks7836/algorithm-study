package com.company.코딩테스트;


class Solution1 {

    /**
     * 최소 공배수의 합
     */
    public int solution(int[] arr) {

        int answer = 0;

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                int maxDivide = 최대공약수(arr[i], arr[j]);

                answer += (arr[i] * arr[j]) / maxDivide;
            }
        }

        return answer;
    }

    private int 최대공약수(int a, int b) {

        int min = Math.min(a, b);

        for (int i = min; i >= 1; i--) {
            if(a % i == 0 && b % i == 0){
                return i;
            }
        }

        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        Solution1 T = new Solution1();
        System.out.println(T.solution(new int[]{1, 2, 3}));
    }
}