package com.company.대기업유제.그래프;

import java.util.*;

class 교육과정 {
	public String[] solution(String[] subjects, String[] course){
		String[] answer = {};

		/**
		 * n개의 교육과정 수료해야함
		 * 교육과목에는 선수과목이 있다.
		 * 선수과목 관련해서는 위상정렬을 사용한다.
		 * n개의 과목을 모두 이수할수있는 순서를 배열에 담아 반환
		 * (답이 여러개면 그 중 아무거나 반환) 위상정렬의 특징
		 * subjects : n개의 과목 목록
		 * course : 선수과목 정보
		 * */

		//먼저 선수과목을 구분하기 위해 노드들을 생성
		Map<String, Node> nodes = createNodes(subjects, course);

		//후위순회로 탐색
		LinkedList<String> result = new LinkedList();

		Set<Node> discovered = new HashSet<>();

		for (var entry : nodes.entrySet()) {

			if(!discovered.contains(entry.getValue())){
				DFS(entry.getValue(), result, discovered);
			}

		}

		return result.toArray(String[]::new);
    }

	private void DFS(Node node, LinkedList<String> result, Set<Node> discovered) {

		discovered.add(node);

		for (Node next : node.nexts) {
			if(!discovered.contains(next)){
				DFS(next, result, discovered);
			}
		}

		result.addFirst(node.name);
	}


	private Map<String, Node> createNodes(String[] subjects, String[] course) {

		Map<String, Node> nodeMap = new HashMap<>();

		for (String subject : subjects) {
			nodeMap.put(subject, new Node(subject));
		}

		for (String s : course) {

			String[] split = s.split(" ");
			//선수과목
			String parent = split[1]; // parent -> child

			String child = split[0];

			Node parentNode = nodeMap.get(parent);
			Node childNode = nodeMap.get(child);

			parentNode.nexts.add(childNode);
		}
		return nodeMap;
	}

	class Node{

		public Node(String name) {
			this.name = name;
		}

		final String name;
		Set<Node> nexts = new HashSet<>(); //하위 과목
	}


		
	public static void main(String[] args){
		교육과정 T = new 교육과정();

		System.out.println(Arrays.toString(T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"})));
		System.out.println(Arrays.toString(T.solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"})));
		System.out.println(Arrays.toString(T.solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"})));
	}
}