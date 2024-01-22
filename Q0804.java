// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/131701

// 원형 수열은 처음과 끝이 연결되어 끊기는 부분이 없기 때문에 연속하는 부분 수열도 일반적인 수열보다 많아집니다.
// 원형 수열의 모든 원소 elements가 순서대로 주어질 때, 
// 원형 수열의 연속 부분 수열 합으로 만들 수 있는 수의 개수를 return

//두번째 시도 성공.
import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        for(int add = 1; add <= elements.length; add++) {
            for(int start = 0; start < elements.length; start++) {
                int sum = 0;
                for(int idx = start; idx < start+add; idx++) {
                    sum += elements[idx % elements.length];
                }
                set.add(sum);
            }
        }
        int answer = set.size();
        return answer;
    }
} 

//첫번째 시도 실패. 런타임 에러
import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= elements.length; i++) {
            int idx = 0;
            while(true) {
                int sum = 0, cnt = 0;
                while(cnt < i) {
                    sum += elements[idx++];
                    cnt++;
                    if(idx == elements.length) {
                        idx = 0;
                    }
                }
                set.add(sum);
                idx -= (i - 1);
                if(idx < 0) {
                    idx += elements.length;
                } else if(idx == ) {
                    break;
                }
            }
        }
        int answer = set.size();
        return answer;
    }
}       
            
            