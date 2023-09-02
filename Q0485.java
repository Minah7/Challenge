// 정수 배열 numbers가 주어집니다. 
// numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.

// 성공

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> sumArr = new ArrayList<>();
        for(int i = 0; i < numbers.length-1; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                int sum = numbers[i]+numbers[j];
                if(!sumArr.contains(sum)) sumArr.add(sum);
            }
        }
        int[] answer = new int[sumArr.size()];
        for(int i = 0; i < sumArr.size(); i++) {
            answer[i] = sumArr.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}