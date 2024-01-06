// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/1845

// N마리 폰켓몬의 종류 번호가 담긴 배열 nums가 매개변수로 주어질 때, 
// N/2마리의 폰켓몬을 선택하는 방법 중, 
// 가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아, 
// 그때의 폰켓몬 종류 번호의 개수를 return

//성공.

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length/2;
        
        Set<Integer> singleNumber = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            singleNumber.add(nums[i]);
        } // 중복된 폰켓몬 종류 제거
        
        if(singleNumber.size() < answer) {
            answer = singleNumber.size();
        }
        
        return answer;
    }
}