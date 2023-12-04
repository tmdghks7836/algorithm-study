package com.company.대기업유제.시뮬레이션;

import java.util.*;

class 회의실만남 {


    public class StartEnd {

        int start;
        int end;

        public void setStart(int start) {
            this.start = start;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }

    public int[] solution(int[] enter, int[] exit) {

        Map<Integer, StartEnd> map = new HashMap<>();

        for (int i = 0; i < enter.length; i++) {
            enter[i]--;
            exit[i]--;
            map.put(i, new StartEnd());
        }

        int timerCnt = 0;


        for (int i = 0, j = 0; i < exit.length; i++) {

            int exitMan = exit[i];

            while (j < enter.length && enter[j] != exitMan) {

                map.get(j).start = timerCnt++;
                j++;
            }
            if (j < enter.length) {
                map.get(j++).start = timerCnt++;
            }

            map.get(exitMan).end = timerCnt++;
        }

        int[] result = new int[enter.length];

        for (int i = 0; i < map.keySet().size(); i++) {

            for (int j = i + 1; j < map.keySet().size(); j++) {

                if ((map.get(i).start < map.get(j).end && map.get(i).end > map.get(j).end)
                        || (map.get(i).start < map.get(j).start && map.get(i).end > map.get(j).start)) {
                    result[i]++;
                    result[j]++;
                }
            }
        }


        return result;
    }

    //enter = [등번호1,등번호2,등번호5,등번호3,등번호4]
    //exit = [등번호2,등번호3,등번호1,등번호4,등번호5]
    // enterIdx = [1등,2등,4등,5등,3등]
    public static void main(String[] args) {
        회의실만남 T = new 회의실만남();
//        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
//        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
//        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
//        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }
}