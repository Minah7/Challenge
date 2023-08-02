// 문자열 my_string이 매개변수로 주어집니다. 
// my_string안의 모든 자연수들의 합을 return하도록 solution 함수를 완성해주세요.

// 성공

class Solution {
    public int solution(String myString) {
        int answer = 0;
        String[] myS = myString.split("");
        for(int i = 0; i < myString.length(); i++) {
            if(Character.isDigit(myString.charAt(i))){
                answer += Integer.valueOf(myS[i]);
            }
        }
        return answer;
    }
}