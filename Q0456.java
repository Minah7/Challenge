// 이진수를 의미하는 두 개의 문자열 bin1과 bin2가 매개변수로 주어질 때, 
// 두 이진수의 합을 return하도록 solution 함수를 완성해주세요.

// 성공

class Solution {
    public String solution(String bin1, String bin2) {
        int b1 = Integer.parseInt(bin1, 2);
        int b2 = Integer.parseInt(bin2, 2);
        String answer = Integer.toBinaryString(b1+b2);
        return answer;
    }
}