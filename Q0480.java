// 문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 
// 각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 
// 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.

// 실패

class Solution {
    public String solution(String s) {
        //문자열을 전부 소문자로 변경해주기
        s = s.toLowerCase();
        //문자 넣을 문자열 
        String[] words = s.split(" ");
        String answer = "";
        for(int word = 0; word < words.length; word++) {
            for(int i = 0; i < words[word].length(); i++) {
                if (i%2 == 0) {
                    answer += words[word].substring(i, i+1).toUpperCase();
                } else {
                    answer += words[word].substring(i, i+1).toLowerCase();
                }
            }
            if(word < words.length-1) {
                answer += " ";
            }
        }
        
        return answer;
    }
}