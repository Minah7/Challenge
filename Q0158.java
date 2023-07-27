정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.

성공

class Solution {
    public double solution(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double answer = sum/(double)arr.length;
        return answer;
    }
}