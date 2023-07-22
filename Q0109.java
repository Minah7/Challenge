// 문자열 my_string과 정수 s, e가 매개변수로 주어질 때, 
// my_string에서 인덱스 s부터 인덱스 e까지를 뒤집은 문자열을 return 하는 solution 함수를 작성해 주세요.

class Solution {
    public String solution(String myString, int s, int e) {
        char[] m_s = myString.toCharArray();
        while (s<e) {
            char temp = m_s[e]; m_s[e] = m_s[s]; m_s[s]=temp;
            s++;
            e--;
        }
        return new String(m_s);
    }
}


//성공.
