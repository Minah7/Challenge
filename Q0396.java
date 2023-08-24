// array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
// divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.

// 성공

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        List<Integer> div = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i]%divisor == 0) {
                div.add(arr[i]);
            }
        }
        if(div.size() == 0) {
            answer = new int[] {-1};
        } else if(div.size() > 0) {
            answer = new int[div.size()];
            for(int j = 0; j < div.size(); j++) {
                answer[j] = div.get(j);
            }
        }
        Arrays.sort(answer);
        return answer;
    }
}