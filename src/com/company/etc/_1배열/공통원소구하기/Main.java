package com.company.etc._1배열.공통원소구하기;

import java.util.*;

/**
 * 2. 공통원소 구하기
 * 설명
 * <p>
 * A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
 * <p>
 * <p>
 * 입력
 * 첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
 * <p>
 * 두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 * <p>
 * 세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
 * <p>
 * 네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 * <p>
 * 각 집합의 원소는 1,000,000,000이하의 자연수입니다.
 * <p>
 * <p>
 * 출력
 * 두 집합의 공통원소를 오름차순 정렬하여 출력합니다.
 * <p>
 * <p>
 * 예시 입력 1
 * <p>
 * 5
 * 1 3 9 5 2
 * 5
 * 3 2 5 7 8
 * 예시 출력 1
 * <p>
 * 2 3 5
 */
public class Main {


    public String solution(Integer[] firstArr, Integer[] secondArr) {

        List<Integer> result = new ArrayList<>();

        Arrays.sort(firstArr);
        Arrays.sort(secondArr);
        int first = 0;
        int second = 0;

        for (int i = 0; i < firstArr.length + secondArr.length; i++) {

            if (first > firstArr.length - 1 || second > secondArr.length - 1) {
                break;
            }
            if (firstArr[first] > secondArr[second]) {
                second++;
            } else if (firstArr[first] < secondArr[second]) {
                first++;
            }else{

                result.add(firstArr[first]);
                second++;
                first++;
            }
        }
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append(" ");
        }
        return sb.toString();
    }


    public void sort(Integer[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        Integer first = in.nextInt();

        Integer[] firstArr = new Integer[first];

        for (int i = 0; i < firstArr.length; i++) {

            firstArr[i] = in.nextInt();
        }

        Integer second = in.nextInt();

        Integer[] secondArr = new Integer[second];

        for (int i = 0; i < secondArr.length; i++) {

            secondArr[i] = in.nextInt();
        }
        System.out.println(T.solution(firstArr, secondArr));
    }
}
