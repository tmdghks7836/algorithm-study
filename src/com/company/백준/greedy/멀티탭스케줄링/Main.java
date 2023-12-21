package com.company.백준.greedy.멀티탭스케줄링;

import java.util.*;

public class Main {

    public void solution() {

        Scanner sc = new Scanner(System.in);

        /**
         * 플러그 빼는 횟수 최소화
         *
         *
         *
         * */

        int hole = sc.nextInt();
        int k = sc.nextInt();


        Set<Integer> consent = new HashSet<>();
        List<Integer> values = new ArrayList<>();


        for (int i = 0; i < k; i++) {

            values.add(sc.nextInt());
        }

        int reslt = 0;
        for (int i = 0; i < k; i++) {

            Integer num = values.get(i);
            if (consent.contains(num)) continue;
            if (consent.size() < hole) {
                consent.add(num);
                continue;
            }

            int max = -1, idx =-1;
            for(int s : consent) {
                int tmp=0;
                List<Integer> sub = values.subList(i+1, k);
                if(sub.contains(s)) {
                    tmp = sub.indexOf(s)+1;
                }
                else {
                    tmp = k-i-1;
                }

                if(tmp > max) {
                    max = tmp;
                    idx= s;
                }
            }

            consent.remove(idx);
            consent.add(num);
            reslt++;
//            Set<Integer> temp = new HashSet<>();
//
//            for (int j = i + 1; j < values.size(); j++) {
//
//                if (consent.contains(values.get(j))) {
//                    temp.add(values.get(j));
//                }
//
//                if (temp.size() == consent.size() - 1) {
//                    break;
//                }
//            }
//
//            Optional<Integer> first = consent.stream().filter(integer -> !temp.contains(integer)).findFirst();
//
//            if (first.isPresent()) {
//                consent.remove(first.get());
//                reslt++;
//                consent.add(values.get(i));
//            }
        }

        System.out.println(reslt);
    }


    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}