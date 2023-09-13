// 정수 배열 numbers가 매개변수로 주어집니다. 
// numbers의 원소의 평균값을 return하도록 solution 함수를 완성해주세요.

// 성공

class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        for(int n = 0; n < numbers.length; n++) {
            answer += numbers[n];
        }
        answer /= numbers.length;
        return answer;
    }
}