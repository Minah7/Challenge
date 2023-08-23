// 정수 배열 arr가 주어집니다. 배열 안의 2가 모두 포함된 가장 작은 연속된 부분 배열을 return 하는 solution 함수를 완성해 주세요.
// 단, arr에 2가 없는 경우 [-1]을 return 합니다.

// 성공

import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {-1};
        int min = 100000;
        int max = 1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 2) {
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
        }
        if(max >= min) {
            answer = Arrays.copyOfRange(arr, min, max+1);
        }
        return answer;
    }
}