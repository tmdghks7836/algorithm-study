package com.company.백준.DFSBFS.더하기123;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < t; i++) {
           list.add(in.nextInt());
        }

        Integer max = list.stream().max((o1, o2) ->   o1 - o2).get();
        int[] arr= new int[max + 1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for (int i = 4; i <= max; i++) {

            arr[i] = arr[i -1] + arr[i -2] + arr[i -3];
        }

        for (int i = 0; i < list.size(); i++) {

            System.out.println(arr[list.get(i)]);
        }
    }
}