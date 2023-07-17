// 정수 n과 k가 주어졌을 때, 1 이상 n이하의 정수 중에서 
// k의 배수를 오름차순으로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.

import java.util.*;

class Solution {
    public List solution(int n, int k) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i * k <= n; i++) {
                answer.add(i * k);
            }
        return answer;
    }
}

//성공