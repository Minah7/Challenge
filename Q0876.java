// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42884

// 고속도로를 이동하는 차량의 경로 routes가 매개변수로 주어질 때, 
// 모든 차량이 한 번은 단속용 카메라를 만나도록 하려면 최소 몇 대의 카메라를 
// 설치해야 하는지를 return 하도록 solution 함수를 완성하세요.

// 성공

import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        int location = routes[0][1];
        int answer = 1;
        
        for(int i = 1; i < routes. length; i++) {
            if(routes[i][0] > location) {
                answer++;
                location = routes[i][1];
            }
        }
        
        return answer;
    }
}