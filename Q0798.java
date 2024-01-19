// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42577

// 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
// 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return

// 성공

import java.util.*;

class Solution {
    public boolean solution(String[] phoneBook) {
        boolean answer = true;
        
        HashSet<String> set = new HashSet<>();
		for(String number : phoneBook) {
			set.add(number);
		}
		
		out: for(String number : phoneBook) {
			for(int i = 1; i < number.length(); i++) {
				String str = number.substring(0, i);
				if(set.contains(str)) {
					answer = false;
                    break out;
				}
			}
		}
        return answer;
    }
}