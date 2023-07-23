// 문자열 my_string과 이차원 정수 배열 queries가 매개변수로 주어집니다. 
// queries의 원소는 [s, e] 형태로, my_string의 인덱스 s부터 인덱스 e까지를 뒤집으라는 의미입니다. 
// my_string에 queries의 명령을 순서대로 처리한 후의 문자열을 return 하는 solution 함수를 작성해 주세요.

// 성공

import java.util.*;

class Solution {
    public String solution(String myString, int[][] queries) {
        char[] m_s = myString.toCharArray();
        String answer = "";
        for(int s = 0; s < queries.length; s++) {
            while(queries[s][0] < queries[s][1]) {
                char temp = m_s[queries[s][1]]; m_s[queries[s][1]] = m_s[queries[s][0]]; m_s[queries[s][0]]=temp;
                queries[s][0]++;
                queries[s][1]--;
            }
        }
        return new String(m_s);
    }
}