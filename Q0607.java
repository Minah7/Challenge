// 문자열 my_string이 매개변수로 주어질 때, 
// my_string 안에 있는 숫자만 골라 오름차순 정렬한 리스트를 return 하도록 solution 함수를 작성해보세요.

// 성공

import java.util.*;

class Solution {
    public int[] solution(String myString) {
        myString = myString.replaceAll("([a-z])", "");
        int[] answer = new int[myString.length()];
        for(int i = 0; i < myString.length(); i++) {
            answer[i] = myString.charAt(i)-'0';
        }
        Arrays.sort(answer);
        return answer;
    }
}