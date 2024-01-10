// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42747

// 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 
// 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.

//성공

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int cLen = citations.length;
        
        Arrays.sort(citations);
        for(int i = 0; i < cLen; i++) {
            int h = cLen - i;
            if(citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }
}