package com.company.프로그래머스.etc.이진변환반복기;

public class Solution {

    public int[] solution(String s) {
        int[] answer = {0, 0};

        String binaryStr = "";

        while (!binaryStr.equals("1")) {

            binaryStr = "";
            for (char c : s.toCharArray()) {

                if (c != '0') {
                    binaryStr += c;
                } else {
                    answer[1]++;
                }
            }
            answer[0]++;
            s = Integer.toBinaryString(binaryStr.length());
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution("110010101001");
        for (int o : solution1) {
            System.out.println(o);
        }
    }
}