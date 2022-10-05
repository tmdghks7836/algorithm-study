package com.company.크레인인형뽑기;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    int[][] ground;
    int height;

    public int solution(int[][] arr2, int[] moves) {

        ground = arr2;
        height = ground.length;
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < moves.length; i++) {

            int pick = pick(moves[i] - 1);
            if(pick != 0){

                if(stack.size() > 0 && stack.peek() == pick){
                    stack.pop();
                    result += 2;
                }else {
                    stack.add(pick);
                }
            }
        }

        return result;
    }

    public int pick(int pos){

        for (int i = 0; i < height; i++) {

            int peeked = ground[i][pos];
            if(peeked != 0){
                ground[i][pos] = 0;
                return peeked;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        Integer next = in.nextInt();

        int[][] arr2 = new int[next][next];

        for (Integer i = 0; i < next; i++) {
            for (Integer j = 0; j < next; j++) {

                arr2[i][j] = in.nextInt();
            }
        }

        Integer moveCnt = in.nextInt();
        int[] moves = new int[moveCnt];
        for (Integer i = 0; i < moveCnt; i++) {
            moves[i] = in.nextInt();
        }
        System.out.println(T.solution(arr2, moves));
    }
}
