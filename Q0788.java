// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42747

// 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 
// 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.

//실패. 93.8점

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int cLen = citations.length;
        
        Arrays.sort(citations);
        int max = citations[cLen - 1];
        
        out: for(int num = max; num >= citations[0]; num--) {
            int cnt = 0;
            for(int c = cLen-1; c >= 0; c--) {
                if(citations[c] < num) {
                    if(cnt >= num && c+1 <= num) {
                        answer = num;
                        break out;
                    }
                    break;
                }
                cnt++;
            }
        }
        return answer;
    }
}