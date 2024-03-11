// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/77484

// 민우가 구매한 로또 번호를 담은 배열 lottos, 
// 당첨 번호를 담은 배열 win_nums가 매개변수로 주어집니다. 
// 이때, 당첨 가능한 최고 순위와 최저 순위를 차례대로 배열에 담아서 return 하도록 solution 함수를 완성해주세요.

// 성공

import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] winNums) {
        int[] answer = new int[2];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
            list.add(winNums[i]);
        }
        
        int mystery = 0;
        int common = 0;
        for(int i = 0; i < 6; i++) {
            int n = lottos[i];
            if(n == 0) {
                mystery++;
            }
            if(list.contains(n)) {
                common++;
                list.remove(Integer.valueOf(n));
            }
        }
        
        int max = mystery + common;
        if(max < 2) {
            answer[0] = 6;
        } else {
            answer[0] = 7 - max;
        }
        
        if(common < 2) {
            answer[1] = 6;
        } else {
            answer[1] = 7 - common;
        }
        
        
        return answer;
    }
}