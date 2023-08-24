// 정수 배열 arr가 주어집니다. arr를 이용해 새로운 배열 stk를 만드려고 합니다.
// 변수 i를 만들어 초기값을 0으로 설정한 후 i가 arr의 길이보다 작으면 다음 작업을 반복합니다.

// 실패

import java.util.*;

class Solution {
    public List solution(int[] arr) {
        List<Integer> num = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(num.size() == 0) {
                num.add(arr[i]);
            } else if(num.get(num.size()-1) < arr[i]) {
                num.add(arr[i]);
            } else if(num.size() != 0) {
                if(num.get(num.size()-1) >= arr[i]) {
                    num.remove(num.size()-1);
                }
            }
        }
        return num;
    }
}