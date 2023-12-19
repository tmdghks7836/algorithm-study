package com.company.백준.DFSBFS.DSLR;

import java.util.*;

public class Main {

    public void solution() {

        Scanner sc = new Scanner(System.in);

        /**
         * */
        int test = sc.nextInt();

        for (int j = 0; j < test; j++) {

            int str = sc.nextInt();
            int target = sc.nextInt();
            Set<Integer> set = new HashSet<>();

            Queue<Pos> queue = new ArrayDeque<>();

            queue.add(new Pos(str, ""));
            set.add(str);
            boolean done = false;
            while (!queue.isEmpty() && !done) {


                int size = queue.size();

                for (int i = 0; i < size; i++) {

                    Pos poll = queue.poll();

                    if (target == poll.num) {
                        System.out.println(poll.command);
                        done = true;
                    }

                    Calcul[] values = Calcul.values();

                    for (Calcul value : values) {

                        int calc = value.calc(poll.num);

                        if (set.contains(calc)) {
                            continue;
                        }

                        set.add(calc);

                        queue.add(new Pos(calc, poll.command + value.toString()));
                    }

                }
            }
        }


    }

    class Pos {
        int num;
        String command;

        public Pos(int num, String command) {
            this.num = num;
            this.command = command;
        }
    }

    enum Calcul {

        D,
        S,
        L,
        R;

        public int calc(Integer num) {

            switch (this) {
                case D:
                    int i2 = num * 2;
                    return i2 % 10000;
                case S:
                    num = num - 1 < 0 ? 9999 : num - 1;

                    return num;
                case L: // 0234 2340

                    return (num % 1000) * 10 + (num / 1000);
                case R: // 1234   4123

                    return (num % 10) * 1000 + (num / 10);
            }
            return 0;
        }

    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}
/*
0
4 4
0 0 0 0
1 0 0 0
0 0 1 0
0 1 0 0
* */