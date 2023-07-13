
package com.company.프로그래머스.동적계획법.정수삼각형;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    public int solution(int[][] triangle) {

        for (int i = 1; i < triangle.length; i++) {

            triangle[i][0] = triangle[i - 1][0] + triangle[i][0];
            triangle[i][triangle[i].length - 1] = triangle[i - 1][triangle[i - 1].length - 1] + triangle[i][triangle[i].length - 1];

            for (int j = 1; j < triangle[i].length - 1; j++) {


                triangle[i][j] = Math.max(triangle[i - 1][j - 1] + triangle[i][j], triangle[i - 1][j] + triangle[i][j]);


            }
        }

        int asInt = Arrays.stream(triangle[triangle.length - 1]).max().getAsInt();
        return asInt;
    }

    public static void main(String[] args) {

        Solution T = new Solution();

        System.out.println(T.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }

}
