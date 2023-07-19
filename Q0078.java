// 정수 배열 arr과 delete_list가 있습니다. arr의 원소 중 delete_list의 원소를 모두 삭제하고 남은 원소들은 기존의 arr에 있던 순서를 유지한 배열을 return 하는 solution 함수를 작성해 주세요.

import java.util.*;

class Solution {
    public List solution(int[] arr, int[] deleteList) {
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i<arr.length; i++) {
            answer.add(arr[i]);
        }
        for(int i = 0; i<arr.length; i++) {
            for (int d = 0; d < deleteList.length; d++) {
                if (arr[i] == deleteList[d]) {
                    answer.remove(Integer.valueOf(arr[i]));
                }
            }
        }
        return answer;
    }
}

//성공
// Integer.valueOf(arr[i]) 이 부분 블로그에서 힌트 얻음. 