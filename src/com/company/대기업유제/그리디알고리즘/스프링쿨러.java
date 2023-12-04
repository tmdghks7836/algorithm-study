package com.company.대기업유제.그리디알고리즘;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class 스프링쿨러 {

    class Spring implements Comparable<Spring> {

        int leftIdx;
        int rightIdx;

        public Spring(int leftIdx, int rightIdx) {

            if (leftIdx < 0) leftIdx = 0;
            this.leftIdx = leftIdx;
            this.rightIdx = rightIdx;
        }

        @Override
        public int compareTo(Spring o) {
            return this.leftIdx - o.leftIdx;
        }
    }

    public int solution(int n, int[] nums) {


        int answer = 0;

        int[][] line = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {

            int left = Math.max(i - nums[i], 0);
            int right = Math.min(i + nums[i], nums.length - 1);

            line[i][0] = left;
            line[i][1] = right;
        }

        Arrays.stream(line).sorted((o1, o2) -> o1[0] - o2[1]);

        int end = 0, start=0,idx = 0;
        while (end < nums.length -1) {

            while (idx < nums.length -1 &&  line[idx][0] <= start) {

                if(end < line[idx][1]){
                    end = line[idx][1];
                }
                idx++;
            }
            if(start == end) return -1;
            answer++;
            start = end;
            idx = end+1;
        }

        return answer;
    }

    // 0 1  0 2  1 3
    public static void main(String[] args) {
        스프링쿨러 T = new 스프링쿨러();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}