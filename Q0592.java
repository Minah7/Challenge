// 정수 n이 매개변수로 주어질 때, n 이하의 홀수가 오름차순으로 담긴 배열을 return하도록 solution 함수를 완성해주세요.

// 성공

import java.util.*;

class Solution {
    public List solution(int n) {
        List<Integer> answer = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(i%2 == 1) answer.add(i);
        }
        return answer;
    }
}