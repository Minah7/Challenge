// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/181188?language=java

// 각 폭격 미사일의 x 좌표 범위 목록 targets이 매개변수로 주어질 때, 
// 모든 폭격 미사일을 요격하기 위해 필요한 요격 미사일 수의 최솟값을 
// return 하도록 solution 함수를 완성해 주세요.

// 성공

import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        
        int end = targets[0][1];
        answer++;
        
        for(int[] tar : targets) {
            if(tar[0] >= end) {
                end = tar[1];
                answer++;
            }
        }
        
        return answer;
    }
}