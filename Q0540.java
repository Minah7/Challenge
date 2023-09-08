문자열 my_string, overwrite_string과 정수 s가 주어집니다. 
문자열 my_string의 인덱스 s부터 overwrite_string의 길이만큼을 
문자열 overwrite_string으로 바꾼 문자열을 return 하는 solution 함수를 작성해 주세요.

성공

class Solution {
    public String solution(String myString, String overwriteString, int s) {
        String answer = "";
        answer += myString.substring(0,s);
        answer += overwriteString;
        answer += myString.substring(s+overwriteString.length());
        return answer;
    }
}