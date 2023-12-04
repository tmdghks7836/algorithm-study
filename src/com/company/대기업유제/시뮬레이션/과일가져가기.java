package com.company.대기업유제.시뮬레이션;

import java.util.ArrayList;

public class 과일가져가기 {

    //최솟값 찾기
    public int getMin(int[] fruit) {
        int min = 100;
        for (int x : fruit) {
            min = Math.min(min, x);
        }
        return min;
    }

    //최소값이 유일한지?
    public boolean isMinUnique(int[] fruit) {

        int cnt = 0;
        int min = getMin(fruit);

        for (int x : fruit) {
            if (x == min) cnt++;
        }
        return cnt == 1;
    }

    public int getMinIndex(int[] fruit) {

        int min = getMin(fruit);

        for (int i = 0; i < 3; i++) { //최솟값의 인덱스 번호 찾기
            if (fruit[i] == min) return i;
        }

        return 0;
    }

    public int solution(int[][] fruit) {

        int answer = 0;

        int n = fruit.length; //사람 수
        boolean[] ch = new boolean[n];

        for (int i = 0; i < n; i++) { //사람 돌려서

            if (ch[i]) //교환 했는지
                continue;
            if(!isMinUnique(fruit[i])) continue; //최솟값 두개이상이면 굳이 교환할 필요없다.

            for (int j = i + 1; j < n; j++) {

                if (ch[j]) //교환 했는지
                    continue;
                if(!isMinUnique(fruit[j])) continue; //최솟값 두개이상이면 굳이 교환할 필요없다.

                int a = getMinIndex(fruit[i]); // i학생 최솟값 인덱스 구하기
                int b = getMinIndex(fruit[j]); // j학생 최솟값 인덱스 구하기

                if(a != b && fruit[i][b] > 0 && fruit[j][a] > 0 ){ //교환할 과일이 같지 않고, 줄수있는 과일이 하나이상존재하면

                    if(fruit[i][a] + 1 <= fruit[i][b] -1 && fruit[j][b] + 1 <= fruit[j][a] -1 ) { //만약 교환 이후 각 학생들의 최솟값이 손해가 없다면

                        fruit[i][a]++;
                        fruit[i][b]--;

                        fruit[j][a]--;
                        fruit[j][b]++;
                        ch[i] = true;
                        ch[j] = true;
                        break;
                    }
                }
            }
        }

        for(int[] x: fruit){
            answer += getMin(x);
        }
        return answer;
    }

    public static void main(String[] args) {

        과일가져가기 T = new 과일가져가기();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}