// 정수로 이루어진 문자열 n_str이 주어질 때, 
// n_str의 가장 왼쪽에 처음으로 등장하는 0들을 뗀 문자열을 return하도록 solution 함수를 완성해주세요.

// 성공

class Solution {
    public String solution(String nStr) {
        String answer = "";
        for(int i = 0; i < nStr.length(); i++) {
            if(nStr.charAt(i) != '0') {
                answer = nStr.substring(i);
                break;
            }
        }
        return answer;
    }
}