// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42576
// 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 
// 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
// 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

//성공.

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> athlete = new HashMap<>();

        // 참가자 해시맵에 담기
        for(String person : participant) {
            athlete.put(person, athlete.getOrDefault(person, 0) + 1);
        }

        // 완주한 선수 빼기
        for(String person : completion) {
            athlete.put(person, athlete.get(person) - 1);
        }
        
        // 남아있는 참가자 확인
        for(Map.Entry<String, Integer> entry : athlete.entrySet()) {
            if(entry.getValue() != 0) {
                answer = entry.getKey();
            }
        }
        return answer;
    }
}