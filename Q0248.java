정수 배열 numbers가 매개변수로 주어집니다. numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 return하도록 solution 함수를 완성해주세요.

성공

import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int answer = 0;
        
        if(numbers[0] < 0 && numbers[1] < 0) {
            if(numbers[numbers.length-2] > 0 && numbers[numbers.length-1] > 0) {
                int mulN = numbers[0]*numbers[1];
                int mulP = numbers[numbers.length-2]*numbers[numbers.length-1];
                if(mulN> mulP) {
                    answer = mulN;
                } else {
                    answer = mulP;
                }
            } else {
                answer = numbers[0]*numbers[1];
            }
        } else {
            answer = numbers[numbers.length-2]*numbers[numbers.length-1];
        }
        return answer;
    }
}