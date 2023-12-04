package com.company.대기업유제.자료구조활용;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/** 문제 해법
 *
 * 수열을 돌아보면서 현재 원소는 연속되는 수중에 가장 작은 수여야 한다. 그러니까 연속수열 중 가장 작은지 비교해본다.
 * 방법으로는 -1을 해서 비교해본다.
 * -1해서 있을경우 현재원소보다 작은 값이 있다는 증거
 * 없을 경우 현재원소는 가장 작은 값임.
 * 가장 작은값이면 +1씩해보면서 연속수가있는지 찾는다.
 * */
class 최대길이연속수열 {
    public int solution(int[] nums) {
        int answer = 1;

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        Integer[] array = set.stream().toArray(Integer[]::new);

        for (int i = 0; i < array.length - 1; i++) {

            Integer num = array[i];

            int tempAnswer = 0;
            //자기보다 1 작은애가 없으면 연속수열 찾아보기
            if (!set.contains(num - 1)) {

                Integer tempNum = num;
                //1증가하면서 연속수열 찾기
                while (set.contains(tempNum++)) {
                    tempAnswer++;
                }
            }

            answer = Math.max(tempAnswer, answer);

        }


        return answer;
    }

    public static void main(String[] args) {
        최대길이연속수열 T = new 최대길이연속수열();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}