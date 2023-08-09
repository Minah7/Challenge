// 문자열 s가 매개변수로 주어집니다. 
// s에서 한 번만 등장하는 문자를 사전 순으로 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요. 
// 한 번만 등장하는 문자가 없을 경우 빈 문자열을 return 합니다.

// 성공

import java.util.*;

class Solution {
    public String solution(String s) {
        String S = "";
        for(int i = 0; i < s.length(); i++) {
            int cnt = 0;
            for(int j = 0; j < s.length(); j++) {
                if(i != j) {
                    if(s.charAt(i) == s.charAt(j)) cnt++;
                }
            }
            if(cnt == 0) {
                S += s.charAt(i);
            }
            cnt = 0;
        }
        
        char[] arr = S.toCharArray();
        Arrays.sort(arr);
        String answer = new String(arr);
        return answer;
    }
}