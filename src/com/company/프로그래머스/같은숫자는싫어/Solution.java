package com.company.프로그래머스.같은숫자는싫어;


import java.util.*;

public class Solution {
    public Integer[] solution(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        stack.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {

            int arrI = arr[i];
            if (arrI != stack.peek())
                stack.add(arrI);
        }

        return stack.toArray(Integer[]::new);
    }
}