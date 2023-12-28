// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/136798
// 실패. 시간초과. 70.4점

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 0; i < number; i++) {
            int knight = i+1;
            int factor = 0;
            for(int d = 1; d <= knight; d++) {
                if(knight%d == 0) {
                    factor++;
                }
                if(factor > limit) {
                    answer+= power;
                    factor = 0;
                    break;
                }
            }
            answer+= factor;
        }
        return answer;
    }
}