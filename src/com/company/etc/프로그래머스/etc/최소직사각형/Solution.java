package com.company.etc.프로그래머스.etc.최소직사각형;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

     public int solution(int[][] sizes) {

         for (int i = 0; i < sizes.length; i++) {

             if(sizes[i][0] < sizes[i][1]){

                 int temp = sizes[i][1];
                 sizes[i][1] = sizes[i][0];
                 sizes[i][0] = temp;
             }
         }

         Arrays.sort(sizes, Comparator.comparingInt(o -> -o[0]));

         int second = 0;

         for (int i = 0; i < sizes.length; i++) {

             second = Math.max(second, sizes[i][1]);
         }

         return sizes[0][0] * second;
     }


    public static void main(String[] args) {

        Solution T = new Solution();

        int solution = T.solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}});
        System.out.println(solution);
    }
}