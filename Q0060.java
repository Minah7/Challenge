//문자열 str1과 str2가 주어질 때, str1이 str2의 부분 문자열이라면 1을 부분 문자열이 아니라면 0을 return하도록 solution 함수를 완성해주세요.

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        if (str2.contains(str1)) {
            answer = 1;
        } else {
            answer = 0;
        }
        return answer;
    }
}

//성공