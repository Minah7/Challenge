// 정수 l과 r이 주어졌을 때, l 이상 r이하의 정수 중에서 숫자 "0"과 "5"로만 이루어진 모든 정수를 오름차순으로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.

// 만약 그러한 정수가 없다면, -1이 담긴 배열을 return 합니다.

// 성공

import java.util.ArrayList;

class Solution {
    public ArrayList solution(int l, int r) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = l; i <= r; i++) {
            String a = String.valueOf(i);
            String b = "";
            for(int j = 0; j < a.length(); j++) {
                if(a.charAt(j)-'0' == 0 || a.charAt(j)-'0' == 5) {
                    b += a.charAt(j);
                } 
            }
            if(a.equals(b)) answer.add(Integer.valueOf(a));
        }
        if(answer.isEmpty()) {
            answer.add(-1);
        }
        return answer;
    }
}