// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42889

// 실패율을 구하는 코드를 완성하라.
// 실패율은 다음과 같이 정의한다.
// 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수

//성공

import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        double[] countStage = new double[N+1];
        for(int i = 0; i < stages.length; i++) {
            countStage[stages[i] - 1]++;
        }

        double[] players = new double[N+1];
        players[N] = countStage[N];
        for(int i = N-1; i >= 0; i--) {
            players[i] = players[i+1] + countStage[i]; 
        }

        Map<Integer, Double> failure = new HashMap<>();
        for(int i = 0; i < N; i++) {
            if(countStage[i] == 0 || countStage[i] == 0) {
                failure.put(i+1, 0.0);
            } else {
                failure.put(i+1, countStage[i] / players[i]);
            }
        }
        
        List<Integer> list = new ArrayList<>(failure.keySet());
        list.sort((o1, o2) -> Double.compare(failure.get(o2), failure.get(o1)));
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}