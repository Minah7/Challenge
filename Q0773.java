// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12981
// 1. 1번부터 번호 순서대로 한 사람씩 차례대로 단어를 말합니다.
// 2. 마지막 사람이 단어를 말한 다음에는 다시 1번부터 시작합니다.
// 3. 앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
// 4. 이전에 등장했던 단어는 사용할 수 없습니다.
// 5. 한 글자인 단어는 인정되지 않습니다.
// 성공.

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        ArrayList<String> check = new ArrayList<>();
        check.add(words[0]);
        for(int i = 1; i < words.length; i++) {
            if(words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1) || check.contains(words[i])) {
                answer[0] = i%n+1;
                answer[1] = (i+1-answer[0])/n+1;
                break;
            }
            check.add(words[i]);
        }
        return answer;
    }
}