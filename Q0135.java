// 정수 배열 numbers가 매개변수로 주어집니다. 
// numbers의 원소의 평균값을 return하도록 solution 함수를 완성해주세요.

// 성공

class Solution {
    public double solution(int[] numbers) {
        int sum = 0;
        for(int i = 0; i < numbers.length; i ++) {
            sum += numbers[i];
        }
        double answer = (double)sum/numbers.length;
        return answer;
    }
}