// 한 자리 정수로 이루어진 문자열 num_str이 주어질 때, 각 자리수의 합을 return하도록 solution 함수를 완성해주세요.

// 성공

class Solution {
    public int solution(String numStr) {
        int answer = 0;
        for(int i = 0; i < numStr.length(); i++) {
            answer+= Character.getNumericValue(numStr.charAt(i));
        }
        return answer;
    }
}