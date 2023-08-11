// 정수 배열 arr이 매개변수로 주어집니다. 
// arr의 길이가 2의 정수 거듭제곱이 되도록 arr 뒤에 정수 0을 추가하려고 합니다. 
// arr에 최소한의 개수로 0을 추가한 배열을 return 하는 solution 함수를 작성해 주세요.

// 실패

import java.util.ArrayList;

class Solution {
    public ArrayList solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int power = 1;
        int num = 0;
        for(int i = 0; i < 10; i++) {
            power *= 2;
            if(arr.length == power) {
                num = i;
            } else if(arr.length < power) {
                num = i;
                power = 1;
                break;
            }
        }
        
        for(int j = 0; j <= num; j++) {
            power *= 2;
        }
        
        for(int i = 0; i < power; i++) {
            answer.add(arr[i]);
            if(i > arr.length) {
                answer.add(0);
            }
        }
        return answer;
    }
}