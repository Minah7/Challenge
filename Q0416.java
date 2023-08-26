// 정수 배열 arr이 매개변수로 주어집니다. 
// arr의 길이가 2의 정수 거듭제곱이 되도록 arr 뒤에 정수 0을 추가하려고 합니다. arr에 최소한의 개수로 0을 추가한 배열을 return 하는 solution 함수를 작성해 주세요.

// 성공

class Solution {
    public int[] solution(int[] arr) {
        int p = 0;
        for(int i = 0; i <= 10; i++) {
            double power = Math.pow(2, i);
            if(arr.length <= power) {
                p = i;
                break;
            }
        }
        double length = Math.pow(2, p);
        int[] answer = new int[(int)length];
        for(int i = 0; i < (int)length; i++) {
            if(i < arr.length) {
                answer[i] = arr[i];
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }
}