package com.company.프로그래머스.etc.기능개발;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public class Day {

        int value;
        int count;

        public int getCount() {
            return count;
        }
    }

    public Integer[] solution(int[] progresses, int[] speeds) {

        Stack<Day> stack = new Stack<>();

        for (int i = 0; i < progresses.length; i++) {

            int progress = progresses[i];
            int speed = speeds[i];
            Day day = new Day();
            double i2 = 100d - progress;
            day.value = (int) Math.ceil(i2 / speed);
            day.count++;

            if (stack.isEmpty() || stack.peek().value < day.value) {
                stack.add(day);
            } else {
                stack.peek().count++;
            }
        }

        return stack.stream().map(Day::getCount).toArray(Integer[]::new);
    }

    public static void main(String[] args) {

        Solution T = new Solution();

        Integer[] solution = T.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        System.out.println(Arrays.toString(solution));
    }
}