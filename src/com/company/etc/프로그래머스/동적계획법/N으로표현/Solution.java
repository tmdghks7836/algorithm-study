
package com.company.etc.프로그래머스.동적계획법.N으로표현;

import java.util.HashSet;
import java.util.Set;

class Solution {

    static int answer = -1;

    public static int solution(int N, int number) {
        Set<Integer>[] set = new HashSet[9];
        int n = 0;

        for (int i = 1; i < set.length; i++) {

            n = (n * 10) + N;
            set[i] = new HashSet<>();
            set[i].add(n);
        }

        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < i; j++) {
                for (Integer a : set[j]) {
                    for (Integer b : set[i - j]) {

                        set[i].add(a + b);
                        set[i].add(a - b);
                        set[i].add(a * b);

                        if(b != 0)
                        set[i].add(a / b);

                        if(a != 0)
                            set[i].add(b / a);
                    }
                }
            }

            if (set[i].contains(number)) {

                return i;
            }
        }


        return -1;
    }

    public static void main(String[] args) {

        Solution T = new Solution();

        System.out.println(T.solution(5, 12));
    }

}
