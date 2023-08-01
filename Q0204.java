정수 배열 numbers가 매개변수로 주어집니다. 
numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 return하도록 solution 함수를 완성해주세요.

테스트 1개 실패.. 

class Solution {
    public int solution(int[] numbers) {
        int max = 0;
        int secondMax = 0;
        for(int i = 0; i < numbers.length; i++) {
            if(max < numbers[i]) {
                max = numbers[i];
            }
        }
        for(int j = 0; j < numbers.length; j++) {
            if(secondMax < numbers[j] && numbers[j] < max) {
                secondMax = numbers[j];
            }
        }
        int sum = max * secondMax;
        return sum;
    }
}