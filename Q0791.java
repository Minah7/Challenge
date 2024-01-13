// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42586

// 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 
// 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 
// 각 배포마다 몇 개의 기능이 배포되는지를 return

// 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
// 작업 진도는 100 미만의 자연수입니다.
// 작업 속도는 100 이하의 자연수입니다.
// 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 
// 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.

//성공

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] complete = new int[progresses.length];
        for(int i = 0; i < progresses.length; i++) {
            int rest = 100 - progresses[i];
            complete[i] = (int)Math.ceil((double)rest / (double)speeds[i]);
        } // 각 작업의 배포일 구하기
        
        List<Integer> count = new ArrayList<>();
        int check = complete[0];
        int cnt = 1;
        for(int i = 1, idx = 0; i < complete.length; i++) {
            if(complete[i] > check) {
                check = complete[i];
                count.add(cnt);
                cnt = 1;
            } else {
                cnt++;
            }
            if(i == complete.length - 1) {
                count.add(cnt);
            }
        } // 각 배포마다 몇 개의 기능이 배포되는지 구하기
        
        return  count.stream().mapToInt(i -> i).toArray();
    }
}