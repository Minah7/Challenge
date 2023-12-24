// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12909

// 먼저 문자열에서 같은 알파벳이 2개 붙어 있는 짝을 찾습니다. 
// 그다음, 그 둘을 제거한 뒤, 앞뒤로 문자열을 이어 붙입니다. 
// 이 과정을 반복해서 문자열을 모두 제거한다면 짝지어 제거하기가 종료됩니다.
// 성공적으로 수행할 수 있으면 1을, 아닐 경우 0을 리턴해주면 됩니다.

// 두번째 시도 성공
// [틀림] 처음 푼 코드. 시간초과
class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        
        while(true) {
            boolean check = false;
            for(int i = 0; i < s.length()-1; i++) {
                if(s.charAt(i) == s.charAt(i+1)) {
                    String front = s.substring(0, i);
                    String back = s.substring(i+2);
                    s = front+back;
                    break;
                }
                if(i == s.length()-2) check = true;
            }
            if(check) break;
        }
        if(s.length() == 0) {
            answer = 1;
        }
        return answer;
    }
}

// 정답 코드
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> letter = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            if(!letter.isEmpty() && letter.peek() == s.charAt(i)) {
                letter.pop();
            } else {
                letter.push(s.charAt(i));
            }
        }
        
        if(letter.isEmpty()) answer = 1;

        return answer;
    }
}