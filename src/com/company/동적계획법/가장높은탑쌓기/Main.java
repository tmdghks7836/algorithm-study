package com.company.동적계획법.가장높은탑쌓기;

import java.util.*;

public class Main {

    static int[] dy;

    public static class Cuboid implements Comparable<Cuboid> {

        @Override
        public int compareTo(Cuboid o) {

            if (length == o.length) return o.weight - weight;

            return o.length - length;
        }

        int weight;
        int height;
        int length;

        public Cuboid(int weight, int height, int length) {
            this.weight = weight;
            this.height = height;
            this.length = length;
        }

        @Override
        public String toString() {

            return "length " + length + ",weight " + weight + ",height " + height;
        }
    }

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        int answer = 0;
        dy = new int[n];

        List<Cuboid> list = new ArrayList();
        for (int i = 0; i < n; i++) {

            list.add(new Cuboid(kb.nextInt(), kb.nextInt(), kb.nextInt()));
        }

        Collections.sort(list);

        Cuboid cuboid = list.get(0);
        dy[0] = cuboid.height;

        for (int i = 1; i < list.size(); i++) {

            Cuboid cuboid1 = list.get(i);

            int result = 0;

            for (int j = i - 1; j >= 0; j--) {

                //만약 이전 무게가 더 무거우면?
                Cuboid cuboidJ = list.get(j);
                if(cuboidJ.weight > cuboid1.weight){

                    result = Math.max(result, dy[j]);
                }
            }

            dy[i] = result + cuboid1.height;
            answer = Math.max(dy[i], answer);
        }

        System.out.println(answer);
    }
}
