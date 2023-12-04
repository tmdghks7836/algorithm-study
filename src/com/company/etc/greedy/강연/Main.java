package com.company.etc.greedy.강연;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    private static PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Comparator.reverseOrder());

    public static class Person {

        int money;
        int day;

        public Person(int time, int mean) {
            this.money = time;
            this.day = mean;
        }
    }

    public int solution(PriorityQueue<Person> totQ) {

        int maxDay = totQ.peek().day;
        int answer = 0;
        while (!totQ.isEmpty()) {

            if (totQ.peek().day == maxDay) {
                Person poll = totQ.poll();
                queue.offer(poll.money);
            } else {

                if (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    answer += poll;
                }
                maxDay -= 1;
            }
        }

        Integer poll = queue.poll();
        answer += poll;

        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        PriorityQueue<Person> queue = new PriorityQueue<>(Comparator.comparingInt(o -> -o.day));
        for (int i = 0; i < n; i++) {

            queue.offer(new Person(in.nextInt(), in.nextInt()));
        }

        System.out.println(T.solution(queue));
    }
}
