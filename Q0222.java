정수 n이 매개변수로 주어질 때, n의 약수를 오름차순으로 담은 배열을 return하도록 solution 함수를 완성해주세요.

성공

import java.util.*;
class Solution {
    public List solution(int n) {
        List <Integer> answer = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(n%(i+1) == 0) {
                answer.add(i+1);
            }
        }
        return answer;
    }
}