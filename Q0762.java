// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42840
// 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 
// 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
// 성공

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] quitter1 = {1, 2, 3, 4, 5};
        int[] quitter2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] quitter3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3]; // 1번, 2번, 3번 성적
        for(int i = 0; i < answers.length; i++) {
            if(quitter1[i%5] == answers[i]) {
                score[0]++;
            }
            if(quitter2[i%8] == answers[i]) {
                score[1]++;
            }
            if(quitter3[i%10] == answers[i]) {
                score[2]++;
            }
        } // 각 수포자의 맞은 개수 세기
        
        int[] check = Arrays.copyOf(score, 3);
        Arrays.sort(check);
        int cnt = 2;
        for(int i = 1; i >= 0; i--) {
            if(check[i] != check[2]) {
                break;
            }
            cnt = i;
        } // 가장 높은 점수를 받은 사람이 몇 명인지 구하기
        
        int[] answer = new int[3-cnt];
        for(int i = 0, idx = 0; i < 3; i++) {
            if(score[i] == check[2]) {
                answer[idx++] = i+1;
            } // 가장 높은 점수를 얻은 사람이면 answer 배열에 넣기
        } // 오름차순으로 넣어야 하기 때문에 앞에서부터 시작
        
        return answer;
    }
}