// 정수 리스트 num_list와 정수 n이 주어질 때, num_list를 n 번째 원소 이후의 원소들과 
// n 번째까지의 원소들로 나눠 n 번째 원소 이후의 원소들을 n 번째까지의 원소들 앞에 붙인 리스트를 
// return하도록 solution 함수를 완성해주세요.

import java.util.*;

class Solution {
    public List solution(int[] numList, int n) {
        List<Integer> answer = new ArrayList<>();
        for (int i = n ; i < numList.length; i++) {
            answer.add(numList[i]);
        }
        for (int j = 0; j < n; j++) {
            answer.add(numList[j]);
        }
        return answer;
    }
}

//성공