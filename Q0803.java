// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/136798

// 예를 들어, 15번으로 지정된 기사단원은 15의 약수가 1, 3, 5, 15로 4개 이므로, 공격력이 4인 무기를 구매합니다. 
// 만약, 이웃나라와의 협약으로 정해진 공격력의 제한수치가 3이고 제한수치를 초과한 기사가 사용할 무기의 공격력이 2라면, 
// 15번으로 지정된 기사단원은 무기점에서 공격력이 2인 무기를 구매합니다. 
// 무기를 만들 때, 무기의 공격력 1당 1kg의 철이 필요합니다. 
// 그래서 무기점에서 무기를 모두 만들기 위해 필요한 철의 무게를 미리 계산하려 합니다.

//성공

import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int k = 1; k <= number; k++) {
            Set<Integer> set = new HashSet<>();
            for(int d = 1; d <= Math.sqrt(k); d++) {
                if(k % d == 0) {
                    set.add(d);
                    set.add(k/d);
                }
                if(set.size() > limit) {
                    answer += power;
                    break;
                }
            }
            if(set.size() <= limit) {
                answer+= set.size();
            }
        }
        return answer;
    }
}