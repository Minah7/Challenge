// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/138477
// 명예의 전당 목록의 점수의 개수 k, 
// 1일부터 마지막 날까지 출연한 가수들의 점수인 score가 주어졌을 때, 
// 매일 발표된 명예의 전당의 최하위 점수를 return하는 solution 함수를 완성해주세요.
// 성공

import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int[] topK = new int[k]; // k번째까지의 순위를 담을 배열
        for(int i = 0; i < score.length; i++) {
            if(i < k) {
                topK[0] = score[i];
                Arrays.sort(topK);
                answer[i] = topK[k-1-i];
            } else {
                if(score[i]> topK[0]) {
                    topK[0] = score[i];
                    Arrays.sort(topK);
                    answer[i] = topK[0];
                } else {
                    answer[i] = topK[0];
                }
            }
        }
        return answer;
    }
}