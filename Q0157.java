정수 n이 매개변수로 주어질 때 n의 각 자리 숫자의 합을 return하도록 solution 함수를 완성해주세요
성공

class Solution {
    public int solution(int n) {
        int answer = 0;
        String num = Integer.toString(n);
        for(int i = 0; i < num.length(); i++) {
            answer += Integer.valueOf(num.substring(i, i+1));
        }
        return answer;
    }
}