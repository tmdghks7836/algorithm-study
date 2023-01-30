package com.company.greedy.결혼식;

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

        int time;
        String mean;

        public Person(int time, String mean) {
            this.time = time;
            this.mean = mean;
        }

        @Override
        public int compareTo(Person o) {
            if(this.time == o.time) return this.mean.equals("e") ? -1 : +1;
            return this.time - o.time;
        }
    }

    public int solution(List<Person> list) {

        int cnt = 0;
        Collections.sort(list);
        int result = 0;

        for (int i = 0; i < list.size(); i++) {

            Person person = list.get(i);

            if (person.mean == "s") {
                cnt++;
            }else {
                cnt--;
            }

            result = Math.max(cnt, result);
        }




        return result;
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);


        int n = in.nextInt();

        List<Person> list = new ArrayList<>();
        for (int i = 0; i < n * 2; i++) {

            list.add(new Person(in.nextInt(), i % 2 == 0 ? "s" : "e"));
        }

        System.out.println(T.solution(list));
    }
}
