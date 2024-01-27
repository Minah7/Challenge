// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/132265

// 롤케이크에 올려진 토핑들의 번호를 저장한 정수 배열 topping이 매개변수로 주어질 때, 
// 롤케이크를 공평하게 자르는 방법의 수를 return

//성공.

import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> chul = new HashMap<>();
        Map<Integer, Integer> brother = new HashMap<>();
        
        for(int i = 0; i < topping.length; i++) {
            int n = topping[i];
            brother.put(n, (brother.getOrDefault(n, 0) + 1));
        }
        
        for(int i = 0; i < topping.length; i++) {
            int n = topping[i];
            chul.put(n, (chul.getOrDefault(n, 0) + 1));
            
            if(brother.get(n) - 1 == 0) {
                brother.remove(n);
            } else {
                brother.put(n, brother.get(n) - 1);
            }
            
            if(chul.size() == brother.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}