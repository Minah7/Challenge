// 정수 l과 r이 주어졌을 때, l 이상 r이하의 정수 중에서 숫자 "0"과 "5"로만 이루어진 모든 정수를 오름차순으로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.

// 만약 그러한 정수가 없다면, -1이 담긴 배열을 return 합니다.

// 성공

import java.util.*;

class Solution {
    public List solution(int l, int r) {
        List<Integer> answer = new ArrayList<>();
        for(int n = l; n <= r; n++) {
            String num = String.valueOf(n);
            int cnt = 0;
            for(int i = 0; i < num.length(); i++) {
                if(num.charAt(i) == '0' || num.charAt(i) == '5') cnt++;
            }
            if(num.length() == cnt) {
                answer.add(n);
            }
        }
        if (answer.isEmpty()) answer.add(-1);
        return answer;
    }
}