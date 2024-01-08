// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/131127

// 정현이는 자신이 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우에 맞춰서 회원가입을 하려 합니다.
// 정현이가 원하는 제품을 나타내는 문자열 배열 want와 정현이가 원하는 제품의 수량을 나타내는 정수 배열 number, 
// XYZ 마트에서 할인하는 제품을 나타내는 문자열 배열 discount가 주어졌을 때, 
// 회원등록시 정현이가 원하는 제품을 모두 할인 받을 수 있는 회원등록 날짜의 총 일수를 return
// 가능한 날이 없으면 0을 return

//성공.

import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> item = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            item.put(want[i], number[i]);
        }
        
        for(int i = 0; i < discount.length-10+1; i++) {
            Map<String, Integer> check = new HashMap<>();
            for(int j = 0; j < 10; j++) {
                check.put(discount[i+j], check.getOrDefault(discount[i+j], 0) + 1);
            }
            
            boolean isSame = true;
            for(String key : item.keySet()) {
                if(item.get(key) != check.get(key)) {
                    isSame = false;
                    break;
                }
            }
            
            if(isSame) {
                answer++;
            }
        }
        return answer;
    }
}