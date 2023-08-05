// 문자열 before와 after가 매개변수로 주어질 때, before의 순서를 바꾸어 after를 만들 수 있으면 1을, 만들 수 없으면 0을 return 하도록 solution 함수를 완성해보세요.

// 실패^^

import java.util.*;

class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        List<String> before = new ArrayList<>(before.split(""));
        List<String> after = new ArrayLsit<>(after.split(""));
        for(int i = 0; i < after.length; i++) {
            for(int j = 0; j < before.length; j++) {
                if(after(i).equals(before(j))) {
                    after.remove(before(j));
                    continue;
                }
            }
        }
        if(after.isEmpty()) {
            answer = 1;
        }
        return answer;
    }
}