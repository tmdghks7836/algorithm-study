package com.company.etc._2정렬.좌표정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {

    public class Point implements Comparable<Point> {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {

            if (x == o.x) return this.y - o.y;

            return x - o.x;
        }
    }

    public Object solution(int[] arr, int[] arr2) {

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {

            points.add(new Point(arr[i], arr2[i]));
        }

        Collections.sort(points);
        StringBuilder sb = new StringBuilder();

        for (Point i : points) {
            sb.append(i.x).append(" ").append(i.y).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        int start = in.nextInt();

        int[] arr = new int[start];
        int[] arr2 = new int[start];
        for (int i = 0; i < start; i++) {
            arr[i] = in.nextInt();
            arr2[i] = in.nextInt();
        }
        System.out.println(T.solution(arr, arr2));
    }
}
