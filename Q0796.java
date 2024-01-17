// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42626

// scoville의 길이는 2 이상 1,000,000 이하입니다.
// K는 0 이상 1,000,000,000 이하입니다.
// scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
// 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.

// 두 번째 시도 성공. 오늘 Heap에 대해 공부하면서 PriorityQueue는 처음 사용해 보았다.

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> s = new PriorityQueue<>();
        
        for(int i : scoville) {
            s.offer(i);
        }    
        
        while(s.peek() < K) {
            s.offer(s.poll() + (s.poll()*2));
            answer++;
            
            if(s.size() == 1 && s.peek() < K) {
                answer = -1;
                break;
            }
        }
        return answer;
    }
}

// 첫 시도. 정확성 100%, 효율성 0%
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int sLen = scoville.length;
        int index = 0;
        Arrays.sort(scoville);
        
        while(true) {
            if(index < sLen-1 && scoville[index] < K) {
                scoville[index+1] = scoville[index] + (scoville[index+1]*2);
                index++;
                answer++;
                Arrays.sort(scoville);
            } else if(index < sLen && scoville[index] >= K) {
                break;
            } else {
                answer = -1;
                break;
            }
        }
        return answer;
    }
}