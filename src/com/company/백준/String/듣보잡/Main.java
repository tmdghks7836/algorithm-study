package com.company.백준.String.듣보잡;

import java.util.*;
import java.util.stream.Collectors;

public class Main {


    /**
     *
     */
    public void solution() {

        Scanner sc = new Scanner(System.in);

        int dt = sc.nextInt();
        int bo = sc.nextInt();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < dt; i++) {

            String next = sc.next();
            map.put(next, map.getOrDefault(next, 0) + 1);
        }

        for (int i = 0; i < bo; i++) {

            String next = sc.next();
            map.put(next, map.getOrDefault(next, 0) + 1);
        }

        List<String> result = map.entrySet().stream().filter(stringIntegerEntry -> stringIntegerEntry.getValue() == 2)
                .map(stringIntegerEntry -> stringIntegerEntry.getKey())
                .sorted()
                .collect(Collectors.toList());

        System.out.println(result.size());

        result.forEach(s -> System.out.println(s));
    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}