// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42746

// 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 
// 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 
// return 하도록 solution 함수를 작성해주세요.

// 성공

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(nums, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if(nums[0].equals("0")) {
            return "0";
        }

        String answer = "";
        
        for(int i = 0; i < nums.length; i++) {
            answer += nums[i];
        }
        return answer;
    }
}