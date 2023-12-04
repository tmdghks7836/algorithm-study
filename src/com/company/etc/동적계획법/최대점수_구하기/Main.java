package com.company.etc.동적계획법.최대점수_구하기;

import java.util.*;

//냅색알고리즘
public class Main {

    static int[] dy;
    static int[] coins;

    public static class Quiz {

        int score;
        int limitTime;

        public Quiz(int score, int limitTime) {
            this.score = score;
            this.limitTime = limitTime;
        }
    }

    /**
     * 1. quiz 클래스를 리스트에 담는다.
     * 2. 제한시간순서로 정렬한다.
     * 3. 제한시간 길이만큼 배열 생성
     * 4. 가장 작은 제한시간이하의 배열은 0으로 세팅
     * 5. 이후 for문돌며 냅색알고리즘 진행.
     */
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int quizNum = kb.nextInt();
        int limitTime = kb.nextInt();

        List<Quiz> quizzes = new ArrayList<>();

        for (int i = 0; i < quizNum; i++) {
            quizzes.add(new Quiz(kb.nextInt(), kb.nextInt()));
        }

        quizzes.sort(Comparator.comparingInt(o -> o.limitTime));

        int[] limitTimes = new int[limitTime + 1];

        for (int i = 0; i < quizzes.size(); i++) {
            Quiz quiz = quizzes.get(i);

            for (int j = limitTimes.length -1; j >= quiz.limitTime; j--) {

                //냅색 알고리즘 시작
                int jScore = limitTimes[j - quiz.limitTime] + quiz.score;
                limitTimes[j] = Math.max(limitTimes[j], jScore);
            }
        }

        System.out.println(limitTimes[limitTimes.length -1]);
    }
}
