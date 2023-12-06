package com.company.코딩테스트;

class Solution3 {

    /**
     * 양의 정수인 a값이 주어질 때 1부터 a값 이하에 존재하는 모든 소수의 합을 리턴하는
     * solution 함수를 작성해주세요.
     * <p>
     * 🚩 [제한사항]
     * <p>
     * - 소수란 1과 자기 자신으로만 나눠지는 수 입니다. ( 1인 소수가 아닙니다. )
     * - a는 최소 4부터 주어집니다.
     * 🚩 [입출력 예]
     * <p>
     * a : 5 → 10
     * a : 10 → 17
     * a : 30 → 129
     */
    public int solution(int num) {

        int res = 0;

        for (int i = 0; i <= num; i++) {

            if (isPrime(i)) {
                res += i;
            }
        }
        return res;
    }

    private boolean isPrime(int num) {

        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (int i = 3; i < num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution3 T = new Solution3();
        System.out.println(T.solution(5));
        System.out.println(T.solution(10));
        System.out.println(T.solution(30));
    }
}