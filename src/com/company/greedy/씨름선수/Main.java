package com.company.greedy.씨름선수;

import java.util.*;


public class Main {

    public static class Person implements Comparable<Person> {

        int height;
        int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Person o) {
            return o.height - this.height;
        }
    }

    public int solution(List<Person> list) {

        int cnt = 0;
        Collections.sort(list);

        for (Person person : list) {
            System.out.println(person.height + " " + person.weight);
        }
        int max = Integer.MIN_VALUE;
        for (Person person : list) {

            if(person.weight > max){
                max = person.weight;
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
