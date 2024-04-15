// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/152996

// 어느 공원 놀이터에는 시소가 하나 설치되어 있습니다. 
// 이 시소는 중심으로부터 2(m), 3(m), 4(m) 거리의 지점에 좌석이 하나씩 있습니다.
// 사람들의 몸무게 목록 weights이 주어질 때, 
// 시소 짝꿍이 몇 쌍 존재하는지 구하여 return 하도록 solution 함수를 완성해주세요.

// 실패. 시간초과. 64.7/100


class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        for(int i = 0; i < weights.length - 1; i++) {
            for(int j = i + 1; j < weights.length; j++) {
                if(weights[i] == weights[j]) {
                    answer++;
                    System.out.println(1);
                    continue;
                }
                
                int big = 0;
                int small = 0;
                if(weights[i] > weights[j]) {
                    big = weights[i];
                    small = weights[j];
                } else {
                    big = weights[j];
                    small = weights[i];
                }
                
                if(big * 2 == small * 3) {
                    System.out.println(2 + ", " + 3);
                    answer++;
                } else if(big * 2 == small * 4) {
                    System.out.println(2 + ", " + 4);
                    answer++;
                } else if(big * 3 == small * 4) {
                    System.out.println(3 + ", " + 4);
                    answer++;
                }
            }
        }
        return answer;
    }
}