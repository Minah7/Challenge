// 정수 리스트 num_list와 정수 n이 주어질 때, num_list의 첫 번째 원소부터 마지막 원소까지 
// n개 간격으로 저장되어있는 원소들을 차례로 담은 리스트를 return하도록 solution 함수를 완성해주세요.

import java.util.*;

class Solution {
    public List solution(int[] numList, int n) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < numList.length; i++) {
            if (i % n == 0) {
                 answer.add(numList[i]);
            }
        }
        return answer;
    }
}

//성공