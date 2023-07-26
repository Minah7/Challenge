// 정수 n이 매개변수로 주어질 때, n 이하의 홀수가 오름차순으로 담긴 배열을 return하도록 solution 함수를 완성해주세요.

// 성공

import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer;
        if(n%2 == 0) {
            answer = new int[n/2];
        } else {
            answer = new int[n/2+1];
        }
        int index = 0;
        for(int i = 1; i <= n; i++) {
            if(i%2 == 1) {
                answer[index++] = i;
            }
        }
        return answer;
    }
}