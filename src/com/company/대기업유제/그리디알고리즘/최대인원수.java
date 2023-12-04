package com.company.대기업유제.그리디알고리즘;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class 최대인원수 {
	public int solution(int n, int[][] trans, int[][] bookings){
		int answer= 0;

		//같은 시간대에 태우고 내릴수 있음.
		//역마다 수용인원이 다른 하나의 기차라고 생각하면 됨.

		//1 ~ 4 2명
		//2 ~ 5 1명

		HashMap<Integer, List<Integer>> map = new HashMap<>();

		for (int[] booking : bookings) {

			int tranNum = booking[0];

			if(!map.containsKey(tranNum)){
				map.put(tranNum, new ArrayList<>());
			}

			List<Integer> integers = map.get(tranNum);
			integers.add(booking[1]);
		}

		int[] station = new int[n + 1];

		for (int i = 0; i < trans.length; i++) {

			int[] tran = trans[i];
			int start = tran[0];
			int end = tran[1];
			int cost = tran[2];

			for (int j = start; j < end; j++) {
				station[j] += cost;
			}
		}

		Arrays.stream(bookings).sorted(Comparator.comparingInt(o -> o[0]));
		//역마다 이제 체크한다.
		//역마다의 예약 리스트

		List<Integer> list = new ArrayList<>();

		for (int i = 1; i <= n; i++) {

			//내릴사람 내리기
			int finalI = i;
			int size = list.stream().filter(integer -> finalI == integer).collect(Collectors.toList()).size();
			answer += size;
			list = list.stream().filter(integer -> finalI != integer)
					.collect(Collectors.toList());


			//역에서 탈수있는사람 모두 태우기
			list.addAll(map.getOrDefault(i, Collections.emptyList()));

			list.sort(Comparator.comparingInt(o -> o));

			//가장 가까운 역으로 도착하는 애들만 남기기
			while(station[i] < list.size()){
				list.remove(list.size() -1 );
			}
		}


		return answer;
	}

	public static void main(String[] args){
		최대인원수 T = new 최대인원수();
		System.out.println(T.solution(5, new int[][]{{1, 4, 2}, {2, 5, 1}}, new int[][]{{1, 2}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {2, 5}, {3, 5}, {3, 4}}));
		System.out.println(T.solution(5, new int[][]{{2, 3, 1}, {1, 5, 1}}, new int[][]{{2, 5}, {1, 5}, {1, 3}, {2, 4}, {2, 5}, {2, 3}}));
		System.out.println(T.solution(8, new int[][]{{1, 8, 3}, {3, 8, 1}}, new int[][]{{1, 3}, {5, 8}, {2, 7}, {3, 8}, {2, 7}, {2, 8}, {3, 8}, {6, 8}, {7, 8}, {5, 8}, {2, 5}, {2, 7}, {3, 7}, {3, 8}}));
		System.out.println(T.solution(9, new int[][]{{1, 8, 3}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {5, 8}, {2, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {7, 8}, {5, 8}, {3, 5}, {3, 7}, {4, 7}, {5, 8}}));
		System.out.println(T.solution(9, new int[][]{{2, 7, 2}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {4, 8}, {2, 9}, {5, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {3, 6}, {7, 8}, {5, 8}, {3, 5}, {2, 7}, {1, 7}, {2, 8}}));
	}
}