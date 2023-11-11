package com.company.프로그래머스.그리디.조이스틱;


public class Solution2 {

    public int solution(String name) {
        int answer = 0;
        int length = name.length();

        int index; // 다음 값들을 확인할 때 사용
        int move = length - 1; // 좌우 움직임 수를 체크

        for (int i = 0; i < name.length(); i++) {

            answer += upDown(name.charAt(i));

            index = i + 1;

            while (index < length && name.charAt(index) == 'A') {
                index++;
            }

            int best = i * 2 + length - index;
            move = Math.min(move, best);

            int best2 = (length - index) * 2 + i;
            move = Math.min(move, best2);
        }

        return answer + move;

    }

    public int upDown(char alphabet) {

        int moveNum = alphabet - 65;

        int i2 = 26 - moveNum;

        return Math.min(moveNum, i2);
    }

    public static void main(String[] args) {


        Solution solution = new Solution();

        System.out.println(solution.solution("BBBBAAAAAAAB"));
    }
}
