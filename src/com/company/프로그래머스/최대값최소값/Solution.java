package com.company.프로그래머스.최대값최소값;


import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Solution {


    public String solution(String s) {

        String[] s1 = s.split(" ");
        Supplier<Stream<Integer>> streamSupplier
                = () -> Arrays.stream(s1).map(si -> Integer.parseInt(si));

        Integer min = streamSupplier.get().min(Comparator.comparingInt(o -> o)).get();
        Integer max = streamSupplier.get().max(Comparator.comparingInt(o -> o)).get();

        return min + " " + max;
    }
}