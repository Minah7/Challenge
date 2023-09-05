// 단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 
// 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

// 성공

class Solution {
    public String solution(String s) {
        String answer = "";
        if(s.length()%2 == 0) {
            answer = s.substring(s.length()/2-1, s.length()/2+1);
        } else {
            answer = s.substring(s.length()/2, s.length()/2+1);
        }
        return answer;
    }
}