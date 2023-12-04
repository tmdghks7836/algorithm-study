package com.company.etc._3queue.응급실;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;


public class Main {
    public static class Person {

        public int idx;
        public int priority;

        public Person(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }


    public Object solution(Queue<Person> queue, int start2) {

        int order = 0;

        while (!queue.isEmpty()) {

            Person temp = queue.poll();
            for (Person person : queue) {

                if (temp.priority < person.priority) {

                    queue.add(temp);
                    temp = null;
                    break;
                }
            }

            if (temp != null) {

                order++;
                if(temp.idx == start2){
                    break;
                }
            }


        }

        return order;
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        int start = in.nextInt();

        int start2 = in.nextInt();

        Queue<Person> queue = new ArrayDeque<>();
        for (int i1 = 0; i1 < start; i1++) {
            queue.offer(new Person(i1, in.nextInt()));
        }
        System.out.println(T.solution(queue, start2));
    }
}
