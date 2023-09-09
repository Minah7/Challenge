// 정수 배열 arr와 query가 주어집니다.

// query를 순회하면서 다음 작업을 반복합니다.

// 짝수 인덱스에서는 arr에서 query[i]번 인덱스를 제외하고 배열의 query[i]번 인덱스 뒷부분을 잘라서 버립니다.
// 홀수 인덱스에서는 arr에서 query[i]번 인덱스는 제외하고 배열의 query[i]번 인덱스 앞부분을 잘라서 버립니다.
// 위 작업을 마친 후 남은 arr의 부분 배열을 return 하는 solution 함수를 완성해 주세요.

// 성공

import java.util.*;

class Solution {
    public List solution(int[] arr, int[] query) {
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            answer.add(arr[i]);
        }
        for(int i = 0; i < query.length; i++) {
            if(i%2 == 0) {
                for(int j = answer.size()-1; j > query[i]; j--) {
                    answer.remove(j);
                }
            } else {
                for(int j = query[i]-1; j >= 0; j--) {
                    answer.remove(j);
                }            
            }
        }
        return answer;
    }
}