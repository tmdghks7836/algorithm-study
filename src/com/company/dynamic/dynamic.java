package com.company.dynamic;

import java.util.Arrays;

public class dynamic {

    public static int[] cache;
    public static void main(String[] args) {
        dynamic(10);
        Arrays.stream(cache).forEach(value -> System.out.print(value + " "));

    }

    public static int dynamic(int num) {


        cache = new int[num + 1];
        cache[0] = 0;
        cache[1] = 1;

        for (int i = 2; i < num + 1; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        return cache[num];

    }
}
