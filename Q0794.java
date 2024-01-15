// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42578

// 코니가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return
// 코니는 각 종류별로 최대 1가지 의상만 착용할 수 있습니다. 예를 들어 위 예시의 경우 동그란 안경과 검정 선글라스를 동시에 착용할 수는 없습니다.
// 착용한 의상의 일부가 겹치더라도, 다른 의상이 겹치지 않거나, 혹은 의상을 추가로 더 착용한 경우에는 서로 다른 방법으로 옷을 착용한 것으로 계산합니다.
// 코니는 하루에 최소 한 개의 의상은 입습니다.

// 성공

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> item = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];
            item.put(type, item.getOrDefault(type, 0) + 1);
        }
        
        Iterator<Integer> it = item.values().iterator();
        while(it.hasNext()) {
            answer *= it.next().intValue() + 1;
        }
        
        return answer - 1;
    }
}