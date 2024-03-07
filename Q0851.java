// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/258711

// 그래프의 간선 정보를 담은 2차원 정수 배열 edges가 매개변수로 주어집니다. 
// 이때, 생성한 정점의 번호, 도넛 모양 그래프의 수, 막대 모양 그래프의 수, 
// 8자 모양 그래프의 수를 순서대로 1차원 정수 배열에 담아 return 하도록 solution 함수를 완성해 주세요.

// 미완성

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        int len = edges.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        ArrayList<Integer> list;
        for(int e = 0; e < len; e++) {
            int start = edges[e][0];
            int end = edges[e][1];
            if(map.containsKey(start)) {
                list = map.get(start);
                list.add(end);
            } else {
                list = new ArrayList<>();
                list.add(end);
            }
            map.put(start, list);
        }
        
        return answer;
    }
}