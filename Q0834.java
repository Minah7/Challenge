// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42862

// 전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 
// 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 
// 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.

// 성공

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int lenL = lost.length;
        int lenR = reserve.length;
        int[] uniform = new int[n+1];
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < lenR; i++) {
            map.put(reserve[i], 2); 
        }
        for(int i = 0; i < lenL; i++) {
            if(map.containsKey(lost[i])) {
                map.put(lost[i], map.get(lost[i]) - 1);
            } else {
                map.put(lost[i], 0);
            }
        }
        
        for(int i = 1; i <= n; i++) {
            if(map.containsKey(i)) {
                uniform[i] = map.get(i);
            } else {
                uniform[i] = 1;
            }
        }
        
        for(int student = 1; student <= n; student++) {
            if(uniform[student] == 0) {
                if(1 < student && (uniform[student - 1] == 2)) {
                    uniform[student] = 1;
                    uniform[student - 1] -= 1;
                } else if(student < n && (uniform[student + 1] == 2)) {
                    uniform[student] = 1;
                    uniform[student + 1] -= 1; 
                }
            }
        }
        
        for(int student = 1; student <= n; student++) {
            if(uniform[student] > 0) {
                answer++;
            }
        }
        return answer;
    }
}