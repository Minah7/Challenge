// 정수 배열 arr이 매개변수로 주어집니다. 
// arr의 길이가 2의 정수 거듭제곱이 되도록 arr 뒤에 정수 0을 추가하려고 합니다. 
// arr에 최소한의 개수로 0을 추가한 배열을 return 하는 solution 함수를 작성해 주세요.

// 실패. ArrayIndexOutOfBoundsException 에러

class Solution {
    public int[] solution(int[] arr) {
        int lengArr = arr.length;
        int i;
        for(i = 0; i <= 10; i++) {
            double powerI = Math.pow(2, i);
            if(powerI >= lengArr) {
                break;
            }
        }
        double num = Math.pow(2, i);
        int n = (int)num;
        int[] answer = new int[n];
        for(i = 0; i < n; i++) {
            if(i <= lengArr) {
                answer[i] = arr[i];
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }
}