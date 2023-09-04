// 문자열 my_str과 n이 매개변수로 주어질 때, 
// my_str을 길이 n씩 잘라서 저장한 배열을 return하도록 solution 함수를 완성해주세요.

// 성공

import java.util.*;

class Solution {
    public List solution(String myStr, int n) {
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < myStr.length(); i+= n) {
            if(i+n <= myStr.length()) {
                answer.add(myStr.substring(i, i+n));
            } else {
                answer.add(myStr.substring(i));
            }
        }
        return answer;
    }
}