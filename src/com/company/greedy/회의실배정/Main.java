package com.company.greedy.회의실배정;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//5
//2 3
//1 4
//3 5
//4 6
//5 7
public class Main {

    public static class Person implements Comparable<Person> {

        int start;
        int end;

        public Person(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Person o) {
            return this.end - o.end;
        }
    }

    public int solution(List<Person> list) {

        int cnt = 1;
        Collections.sort(list);

        int curEndTime = list.get(0).end;



        for (Person person : list) {

            if (person.start >= curEndTime) {
                curEndTime = person.end;
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);


        int n = in.nextInt();

        List<Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            list.add(new Person(in.nextInt(), in.nextInt()));
        }

        System.out.println(T.solution(list));
    }
}
