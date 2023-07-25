// 문자열 배열 intStrs와 정수 k, s, l가 주어집니다. intStrs의 원소는 숫자로 이루어져 있습니다.
// 배열 intStrs의 각 원소마다 s번 인덱스에서 시작하는 길이 l짜리 부분 문자열을 잘라내 정수로 변환합니다. 
// 이때 변환한 정수값이 k보다 큰 값들을 담은 배열을 return 하는 solution 함수를 완성해 주세요.

// 성공

import java.util.*;

class Solution {
    public List solution(String[] intStrs, int k, int s, int l) {
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < intStrs.length; i++) {
            intStrs[i] = intStrs[i].substring(s, s+l);
            if(Integer.parseInt(intStrs[i]) > k) {
                answer.add(Integer.parseInt(intStrs[i]));
            }
        }
        return answer;
    }
}

//처음 실패한 코드
import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        int[] answer = {};
        int index = 0;
        for(int i = 0; i < intStrs.length; i++) {
            intStrs[i] = intStrs[i].substring(s, s+l);
            if(Integer.parseInt(intStrs[i]) > k) {
                answer[index++] = Integer.parseInt(intStrs[i]);
            }
        }
        return answer;
    }
}