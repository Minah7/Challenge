// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/178871

// 선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 players와 
// 해설진이 부른 이름을 담은 문자열 배열 callings가 매개변수로 주어질 때, 
// 경주가 끝났을 때 선수들의 이름을 1등부터 등수 순서대로 배열에 담아 return

// 성공

import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for(String call : callings) {
            int rank = map.get(call);
            String steal = players[rank - 1];
            
            players[rank - 1] = call;
            map.put(call, rank - 1);
            
            players[rank] = steal;
            map.put(steal, rank);
        }
        
        return players;
    }
}